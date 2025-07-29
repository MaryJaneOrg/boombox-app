package dev.gabrielsancho.boombox.resource

import dev.gabrielsancho.boombox.module.HttpClientConfigScope
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class F1Resource(
    private val httpClientSetup: HttpClientConfigScope
) {

    suspend fun circuits(): HttpResponse {
        return HttpClient(httpClientSetup).use {
            it.get {
                headers {
                    set("x-rapidapi-key", "d11cd994a595c53e87a1db736458538e")
                }
                url("https://v1.formula-1.api-sports.io/circuits")
            }
        }
    }
}


