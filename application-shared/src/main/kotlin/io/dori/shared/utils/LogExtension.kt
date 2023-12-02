package io.dori.shared.utils

import mu.KLogger
import mu.KotlinLogging

fun logger(name: String): KLogger = KotlinLogging.logger(name)
inline fun <reified T : Any> T.logger(): KLogger = KotlinLogging.logger(T::class.java.name)
