package org.drkswg.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class GreetingsControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `test greet endpoint returns Greetings!`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/greet")
        val response: HttpResponse<String> = client.toBlocking().exchange(request, String::class.java)

        assertEquals("Greetings!", response.body())
        assertEquals(200, response.status.code)
    }
}