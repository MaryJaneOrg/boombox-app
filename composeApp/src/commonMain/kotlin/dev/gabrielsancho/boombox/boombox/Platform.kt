package dev.gabrielsancho.boombox.boombox

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform