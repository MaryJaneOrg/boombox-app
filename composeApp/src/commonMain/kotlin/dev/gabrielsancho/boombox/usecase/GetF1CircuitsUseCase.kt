package dev.gabrielsancho.boombox.usecase

import dev.gabrielsancho.boombox.resource.dto.CircuitDTO
import dev.gabrielsancho.boombox.resource.F1Resource

class GetF1CircuitsUseCase(
    private val resource: F1Resource
) {
    suspend operator fun invoke(): List<CircuitDTO> = resource.circuits().response


}