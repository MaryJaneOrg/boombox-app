package dev.gabrielsancho.boombox

import dev.gabrielsancho.boombox.setup.DependencyInjectionSetup

fun StartDI() {
    println("Initializing Dependency Injection for iOS")
    DependencyInjectionSetup.start()
}
