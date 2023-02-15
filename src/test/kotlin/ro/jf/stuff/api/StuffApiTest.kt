package ro.jf.stuff.api

import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class StuffApiTest {

    @Test
    fun `should get stuff`() = testApplication {
        val response = client.get("/api/v1/stuff")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("List stuff!", response.bodyAsText())
    }

    @Test
    fun `should get stuff by id`() = testApplication {
        val response = client.get("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Get stuff with id 123", response.bodyAsText())
    }

    @Test
    fun `should create stuff`() = testApplication {
        val response = client.post("/api/v1/stuff")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Create stuff!", response.bodyAsText())
    }

    @Test
    fun `should update stuff`() = testApplication {
        val response = client.put("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Update stuff with id 123", response.bodyAsText())
    }

    @Test
    fun `should delete stuff`() = testApplication {
        val response = client.delete("/api/v1/stuff/123")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Delete stuff with id 123", response.bodyAsText())
    }
}
