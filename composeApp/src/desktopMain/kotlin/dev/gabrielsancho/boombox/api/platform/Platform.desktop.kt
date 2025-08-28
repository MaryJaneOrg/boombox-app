package dev.gabrielsancho.boombox.api.platform

import java.awt.Desktop
import java.net.URI

private object DesktopPlatform : Platform {
    override fun getName(): String = "Desktop"

    override fun openUrl(url: String) {
        Desktop
            .isDesktopSupported()
            .takeIf { it }
            ?.let { Desktop.getDesktop() }
            ?.takeIf { it.isSupported(Desktop.Action.APP_OPEN_URI) }
            ?.apply { browse(URI(url)) }
    }
}

actual fun getPlatform(): Platform = DesktopPlatform
