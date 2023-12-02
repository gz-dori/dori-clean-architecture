dependencies {
    implementation(project(":application-domain"))
    implementation(project(":application-shared"))

    runtimeOnly(project(":application-http"))
    runtimeOnly(project(":application-datastore"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("io.micrometer:micrometer-registry-prometheus:1.9.2")

    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")

    testImplementation("io.rest-assured:spring-mock-mvc:5.3.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}
