package ro.jf.stuff

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import org.koin.dsl.module
import org.koin.ktor.plugin.koin
import ro.jf.stuff.api.stuffRoutes
import ro.jf.stuff.domain.service.StuffService

fun main(): Unit = EngineMain.main(emptyArray())

fun Application.module() {
    koin {
        modules(stuffModule)
    }
    install(ContentNegotiation) {
        json()
    }
    stuffRoutes()
}

val stuffModule = module {
    single { StuffService() }
}
