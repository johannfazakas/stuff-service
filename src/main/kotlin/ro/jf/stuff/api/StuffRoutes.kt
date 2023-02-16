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
import ro.jf.stuff.domain.service.StuffService
import ro.jf.stuff.utils.toUUID

private const val STUFF_ID = "stuffId"

fun Application.stuffRoutes() {

    // TODO(Johann) inject actual stuffService
    val stuffService = StuffService()

    routing {
        route("/api/v1/stuff") {
            get {
                val stuffList = stuffService.list().map(StuffTO::fromDomain)
                call.respond(HttpStatusCode.OK, stuffList)
            }
            get("/{$STUFF_ID}") {
                val stuffId = call.parameters[STUFF_ID].toUUID()
                val stuff = stuffService.get(stuffId).let(StuffTO::fromDomain)
                call.respond(HttpStatusCode.OK, stuff)
            }
            post {
                val request = call.receive<CreateStuffTO>()
                val stuff = stuffService.create(request.toCommand()).let(StuffTO::fromDomain)
                call.respond(HttpStatusCode.Created, stuff)
            }
            put("/{$STUFF_ID}") {
                val stuffId = call.parameters[STUFF_ID].toUUID()
                val request = call.receive<UpdateStuffTO>()
                val stuff = stuffService.update(request.toCommand(stuffId)).let(StuffTO::fromDomain)
                call.respond(HttpStatusCode.OK, stuff)
            }
            delete("/{$STUFF_ID}") {
                val stuffId = call.parameters[STUFF_ID].toUUID()
                stuffService.delete(stuffId)
                call.respond(HttpStatusCode.NoContent)
            }
        }
    }
}
