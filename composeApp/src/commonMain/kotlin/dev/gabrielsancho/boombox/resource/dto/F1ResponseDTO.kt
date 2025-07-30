package dev.gabrielsancho.boombox.resource.dto

import kotlinx.serialization.Serializable

@Serializable
data class F1ResponseDTO<T>(
    val response: T
)
