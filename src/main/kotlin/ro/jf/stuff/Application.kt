package ro.jf.stuff

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import ro.jf.stuff.api.configureStuffRouting

fun main(): Unit = EngineMain.main(emptyArray())

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    configureStuffRouting()
}
