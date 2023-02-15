package ro.jf.stuff

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import ro.jf.stuff.api.configureStuffRouting

fun main(): Unit = EngineMain.main(emptyArray())

fun Application.module() {
    configureStuffRouting()
}
