package dev.gabrielsancho.boombox.api.platform

interface Platform {
    fun getName(): String
    fun openUrl(url: String)
}

expect fun getPlatform(): Platform
