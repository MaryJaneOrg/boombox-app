package dev.gabrielsancho.boombox

import dev.gabrielsancho.boombox.config.ConfigureDI

fun StartDI() {
    println("Initializing Dependency Injection for iOS")
    ConfigureDI.start()
}
