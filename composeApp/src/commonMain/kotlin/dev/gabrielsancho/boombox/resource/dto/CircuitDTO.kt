package dev.gabrielsancho.boombox.resource.dto

import com.example.example.CompetitionDTO
import kotlinx.serialization.Serializable


@Serializable
data class CircuitDTO(
    val id: Int?,
    val name: String?,
    val image: String?,
    val competition: CompetitionDTO?,
    val firstGrandPrix: Int? = null,
    val laps: Int?,
    val length: String?,
    val raceDistance: String? = null,
    val lapRecord: LapRecordDTO? = null,
    val capacity: Int?,
    val opened: Int?,
    val owner: String = "NO OWNER"
)
