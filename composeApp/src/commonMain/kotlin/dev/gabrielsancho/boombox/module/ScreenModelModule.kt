package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.model.ProfileModel
import org.koin.dsl.module

val screenModelModule = module {
    factory { ProfileModel(get(), it.get()) }
}
