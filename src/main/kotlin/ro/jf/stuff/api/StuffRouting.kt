package ro.jf.stuff.api

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import ro.jf.stuff.api.transfer.StuffTO

fun Application.configureStuffRouting() {

    routing {
        route("/api/v1/stuff") {
            get {
                call.respond(HttpStatusCode.OK, listOf(StuffTO.random(), StuffTO.random()))
            }
            get("/{stuffId}") {
                call.respond(HttpStatusCode.OK, StuffTO.random())
            }
            post {
                call.respond(HttpStatusCode.Created, StuffTO.random())
            }
            put("/{stuffId}") {
                call.respond(HttpStatusCode.OK, StuffTO.random())
            }
            delete("/{stuffId}") {
                call.respond(HttpStatusCode.NoContent)
            }
        }
    }
}
