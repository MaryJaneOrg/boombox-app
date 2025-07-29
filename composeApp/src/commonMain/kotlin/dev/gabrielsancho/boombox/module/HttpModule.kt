package dev.gabrielsancho.boombox.module

import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import org.koin.dsl.module

typealias HttpClientConfigScope = HttpClientConfig<*>.() -> Unit

val httpModule = module {
    single<HttpClientConfigScope> {
        {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }
}
