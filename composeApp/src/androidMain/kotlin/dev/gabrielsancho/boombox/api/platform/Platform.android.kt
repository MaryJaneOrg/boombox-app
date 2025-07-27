package dev.gabrielsancho.boombox.api.platform

object AndroidPlatform : Platform {
    override fun getName(): String = "Android"

}

actual fun getPlatform(): Platform = AndroidPlatform
