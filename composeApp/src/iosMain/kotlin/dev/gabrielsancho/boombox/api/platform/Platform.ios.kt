package dev.gabrielsancho.boombox.api.platform

private object IOSPlatform : Platform {
    override fun getName(): String = "iOS"
}

actual fun getPlatform(): Platform = IOSPlatform