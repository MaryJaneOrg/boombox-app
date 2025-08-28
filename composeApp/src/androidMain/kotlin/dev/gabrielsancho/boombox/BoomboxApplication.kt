package dev.gabrielsancho.boombox

import android.app.Application
import dev.gabrielsancho.boombox.config.ConfigureDI

class BoomboxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ConfigureDI.start()
    }
}
