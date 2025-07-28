package dev.gabrielsancho.boombox

import android.app.Application
import dev.gabrielsancho.boombox.setup.DependencyInjectionSetup

class BoomboxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        DependencyInjectionSetup.start()
    }
}
