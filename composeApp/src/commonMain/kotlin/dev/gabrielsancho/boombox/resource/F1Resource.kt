package dev.gabrielsancho.boombox.resource

import dev.gabrielsancho.boombox.resource.dto.CircuitDTO
import dev.gabrielsancho.boombox.resource.dto.F1ResponseDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class F1Resource(
    private val httpClient: HttpClient
) {
    private val baseUrl: URLBuilder.() -> Unit = {
        protocol = URLProtocol.HTTPS
        host = "v1.formula-1.api-sports.io"
    }

    suspend fun circuits(): F1ResponseDTO<List<CircuitDTO>> {
        return httpClient.use { client ->
            client.get {
                url {
                    baseUrl()
                    path("circuits")
                }

                headers {
                    set("x-rapidapi-key", "d11cd994a595c53e87a1db736458538e")
                }
            }.body()
        }
    }
}
