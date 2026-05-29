package auctions.tracker

import org.http4k.core.*
import org.http4k.format.Jackson.asJsonObject
import org.http4k.format.Jackson.elements

class AuctionClient(val handler: HttpHandler) {

    fun auctionsCatalog(): AuctionsCatalog {
        val request = Request(
            method = Method.GET,
            uri = Uri.of(value = "www.example.com"),
        )
        val response = handler(request)

        if (response.status == Status.NOT_FOUND)
            return AuctionsCatalog(emptyList())

        val jsonObject = response.bodyString().asJsonObject()

        val jsonNodes = elements(jsonObject)

        return AuctionsCatalog(
            auctions = jsonNodes.map {

                val textValue = it.path("status").textValue()
                val mappedStatus = if (textValue == "FINISHED") {
                    "COMPLETED"
                } else textValue

                Auction(
                    name = it.path("name").textValue(),
                    status = AuctionStatus.valueOf(mappedStatus)
                )
            }
        )

    }
}

interface Monitoring {
    fun notify(log: Log)
}

data class Log(val message: String)

