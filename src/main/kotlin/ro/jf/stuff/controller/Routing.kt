package ro.jf.stuff.controller

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.configureStuffRouting() {

    routing {
        route("/api/v1/stuff") {
            get {
                call.respondText("List stuff!")
            }
            get("/{stuffId}") {
                call.respondText("Get stuff with id ${call.parameters["stuffId"]}")
            }
            post {
                call.respondText("Create stuff!")
            }
            put("/{stuffId}") {
                call.respondText("Update stuff with id ${call.parameters["stuffId"]}")
            }
            delete("/{stuffId}") {
                call.respondText("Delete stuff with id ${call.parameters["stuffId"]}")
            }
        }
    }
}
