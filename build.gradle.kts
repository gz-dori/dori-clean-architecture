import com.linecorp.support.project.multi.recipe.configureByLabels
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.8" apply false
    id("io.spring.dependency-management") version "1.0.15.RELEASE" apply false
    id("com.coditory.integration-test") version "1.4.0" apply false
    id("com.linecorp.build-recipe-plugin") version "1.1.1"

    kotlin("jvm") version "1.7.10" apply false
    kotlin("kapt") version "1.7.10" apply false
    kotlin("plugin.spring") version "1.7.10" apply false
    kotlin("plugin.jpa") version "1.7.10" apply false
}

allprojects {
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "com.coditory.integration-test")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    repositories {
        mavenCentral()
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        val testRuntimeOnly by configurations
        val integrationImplementation by configurations
        val integrationRuntimeOnly by configurations

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        // commons util
        implementation("org.apache.commons:commons-lang3:3.7")
        implementation("org.apache.commons:commons-collections4:4.4")

        // kotest
        testImplementation("io.kotest:kotest-runner-junit5:5.3.0")
        testImplementation("io.kotest:kotest-assertions-core:5.3.0")
        testImplementation("io.kotest:kotest-property:5.3.0")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.1")

        // fixture monkey
        testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter-kotlin:0.4.12")

        // mockk
        testImplementation("io.mockk:mockk:1.12.0")

        // mockserver
        integrationImplementation("org.mock-server:mockserver-client-java:5.14.0")
        integrationImplementation("org.mock-server:mockserver-netty:5.14.0")

        // logging
        implementation("io.github.microutils:kotlin-logging:2.1.21")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.8")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.0")
        }
    }

    configure<org.jetbrains.kotlin.allopen.gradle.AllOpenExtension> {
        annotations(
            "javax.persistence.Entity",
            "javax.persistence.MappedSuperclass",
            "javax.persistence.Embeddable",
        )
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configureByLabels("library") {
    apply(plugin = "java-library")

    tasks.getByName<Jar>("jar") {
        enabled = true
    }
}

configureByLabels("boot") {
    apply(plugin = "org.springframework.boot")

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
        enabled = true
    }
}
