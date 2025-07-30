package com.example.example

import dev.gabrielsancho.boombox.resource.dto.LocationDTO
import kotlinx.serialization.Serializable


@Serializable
data class CompetitionDTO(
    val id: Int?,
    val name: String?,
    val location: LocationDTO?
)