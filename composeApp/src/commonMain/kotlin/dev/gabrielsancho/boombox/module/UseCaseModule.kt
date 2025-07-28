package dev.gabrielsancho.boombox.module

import dev.gabrielsancho.boombox.usecase.GetPlatformNameUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetPlatformNameUseCase(get()) }
}
