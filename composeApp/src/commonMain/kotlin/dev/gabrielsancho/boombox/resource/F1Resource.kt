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
    private fun <T> HttpRequestBuilder.f1Resource(path: String, body: T? = null) {
        body?.let { setBody(it) }

        url {
            protocol = URLProtocol.HTTPS
            host = "v1.formula-1.api-sports.io"
            path(path)
        }

        headers {
            set("x-rapidapi-key", "d11cd994a595c53e87a1db736458538e")
        }
    }

    suspend fun circuits(): F1ResponseDTO<List<CircuitDTO>> = httpClient
        .get { f1Resource<Nothing>("circuits") }
        .body()
}
