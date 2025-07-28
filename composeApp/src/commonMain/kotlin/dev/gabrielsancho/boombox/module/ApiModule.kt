package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.api.platform.Platform
import dev.gabrielsancho.boombox.api.platform.getPlatform
import org.koin.dsl.module


val apiModule = module {
    single<Platform> { getPlatform() }
}
