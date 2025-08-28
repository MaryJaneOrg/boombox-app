package dev.gabrielsancho.boombox.config

import dev.gabrielsancho.boombox.module.boomboxModule
import org.koin.core.context.startKoin

object ConfigureDI {

    operator fun invoke() {
        startKoin {
            modules(boomboxModule)
        }
    }
}
