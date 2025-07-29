package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.resource.F1Resource
import org.koin.dsl.module

val resourceModule = module {
    single { F1Resource(get()) }
}