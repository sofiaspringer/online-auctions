package auctions

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.format.Moshi.json
import org.http4k.routing.bind
import org.http4k.routing.routes

class Auctions: HttpHandler {

    private val routing = routes(
        "catalog" bind Method.GET to {
            Response(OK).json(
                listOf(
                    Auction(
                        name = "Auction for pools",
                        startDate = "2025-11-08",
                        endDate = "2025-01-08",
                        status = Status.FINISHED,
                    ),
                    Auction(
                        name = "Auction for fancy paintings",
                        startDate = "2025-01-03",
                        endDate = "2025-01-11",
                        status = Status.IN_PROGRESS,
                    ),
                    Auction(
                        name = "Auction for shows",
                        startDate = "2025-02-05",
                        endDate = "2025-02-15",
                        status = Status.NOT_STARTED,
                    )
                )
            )
        },
    )

    override fun invoke(request: Request): Response =
        routing.invoke(request)
}