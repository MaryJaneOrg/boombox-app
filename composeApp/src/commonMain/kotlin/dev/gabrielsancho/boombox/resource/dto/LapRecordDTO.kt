package dev.gabrielsancho.boombox.resource.dto

import kotlinx.serialization.Serializable


@Serializable
data class LapRecordDTO(
    val time: String?,
    val driver: String?,
    val year: String?
)