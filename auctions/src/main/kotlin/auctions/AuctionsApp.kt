package auctions

import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    val app = Auctions()

    val server = app.asServer(Undertow(8030)).start()

    Runtime.getRuntime().addShutdownHook(Thread {
        server.stop()
    })
}
