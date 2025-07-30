package dev.gabrielsancho.boombox.resource.dto

import kotlinx.serialization.Serializable


@Serializable
data class LocationDTO(
    val country: String?,
    val city: String?
)