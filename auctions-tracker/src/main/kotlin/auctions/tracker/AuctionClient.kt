package auctions.tracker

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response

class AuctionClient(val handler: (Request) -> Response) {

    fun auctionsCatalog(): AuctionsCatalog {
        TODO()
        //val request = Request.get("api")
        //   val response = handler(request)
        //    return AuctionsCatalog()
        // }
    }
}
