package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.model.ProfileModel
import org.koin.dsl.module

val homeModule = module {
    factory { ProfileModel() }
}
