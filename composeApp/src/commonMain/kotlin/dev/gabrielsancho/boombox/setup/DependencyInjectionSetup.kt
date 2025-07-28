package dev.gabrielsancho.boombox.setup

import dev.gabrielsancho.boombox.module.boomboxModule
import org.koin.core.context.startKoin

object DependencyInjectionSetup {
    fun start() {
        startKoin {
            modules(boomboxModule)
        }
    }
}