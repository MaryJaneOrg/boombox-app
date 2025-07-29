package dev.gabrielsancho.boombox.usecase

import dev.gabrielsancho.boombox.resource.F1Resource
import io.ktor.client.statement.*

class GetF1CircuitsUseCase(
    private val resource: F1Resource
) {
    suspend operator fun invoke(): String {
        val response = resource.circuits()

        return response.bodyAsText()
    }
}