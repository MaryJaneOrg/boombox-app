package dev.gabrielsancho.boombox.api.platform

interface Platform {
    fun getName(): String
}
expect fun getPlatform(): Platform
