package dev.gabrielsancho.boombox.api.platform

private object DesktopPlatform : Platform {
    override fun getName(): String = "Desktop"
}

actual fun getPlatform(): Platform = DesktopPlatform
