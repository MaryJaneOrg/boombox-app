package dev.gabrielsancho.boombox

import dev.gabrielsancho.boombox.api.platform.Platform

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()