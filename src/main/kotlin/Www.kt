import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, 1337) {
        routing {
            // curl -v -w "\n" http://localhost:1337/
            get("/") {
                call.respondText("Hello, world!!!!", ContentType.Text.Html)
            }
            // curl -w "\n" -d "AwwYeah!" -X POST http://localhost:1337/echo
            post("/echo") {
                val  text = call.receiveText()
                call.respondText(text, ContentType.Text.Plain)
            }
        }
    }
    server.start(wait = true)
}