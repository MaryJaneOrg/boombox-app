package dev.gabrielsancho.boombox

import dev.gabrielsancho.boombox.api.platform.Platform

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()