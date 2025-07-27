package dev.gabrielsancho.boombox.api.platform

private object WasmPlatform : Platform {
    override fun getName(): String = "WebAssembly"
}

actual fun getPlatform(): Platform = WasmPlatform
