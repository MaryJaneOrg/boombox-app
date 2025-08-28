package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.model.F1Model
import dev.gabrielsancho.boombox.model.LoginModel
import dev.gabrielsancho.boombox.model.ProfileModel
import org.koin.dsl.module

val screenModelModule = module {
    factory { ProfileModel(get(), it.get()) }
    factory { F1Model(get()) }
    factory { LoginModel() }
}
