package dev.gabrielsancho.boombox.usecase

import dev.gabrielsancho.boombox.api.platform.Platform

class GetPlatformNameUseCase(
    private val platform: Platform
) {
    operator fun invoke(): String = platform.getName()
}