package ro.jf.stuff.api

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import ro.jf.stuff.api.transfer.CreateStuffTO
import ro.jf.stuff.api.transfer.StuffTO
import ro.jf.stuff.api.transfer.UpdateStuffTO

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
                val request = call.receive<CreateStuffTO>()
                call.respond(
                    HttpStatusCode.Created, StuffTO(
                        id = request.hashCode(),
                        name = request.name,
                        value = request.value,
                        flag = request.flag,
                        list = request.list,
                    )
                )
            }
            put("/{stuffId}") {
                val request = call.receive<UpdateStuffTO>()
                call.respond(HttpStatusCode.OK, StuffTO.random().copy(name = request.name))
            }
            delete("/{stuffId}") {
                call.respond(HttpStatusCode.NoContent)
            }
        }
    }
}
