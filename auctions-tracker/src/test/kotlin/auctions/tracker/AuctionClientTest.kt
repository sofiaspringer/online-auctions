package auctions.tracker

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import kotlin.test.Test
import kotlin.test.assertEquals


class AuctionClientTest {
    @Test
    fun `reads auctions catalog`() {
        val handler = { _: Request -> Response(Status.OK).body("""
            [
              {
                "name": "Auction for pools",
                "startDate": "2025-11-08",
                "endDate": "2025-01-08",
                "status": "FINISHED"
              },
              {
                "name": "Auction for fancy paintings",
                "startDate": "2025-01-03",
                "endDate": "2025-01-11",
                "status": "IN_PROGRESS"
              },
              {
                "name": "Auction for shows",
                "startDate": "2025-02-05",
                "endDate": "2025-02-15",
                "status": "NOT_STARTED"
              }
            ]
        """.trimIndent())
        }

        val client = AuctionClient(handler)

        val result = client.auctionsCatalog()

        assertEquals(AuctionsCatalog(listOf(
            Auction("Auction for pools", AuctionStatus.COMPLETED),
            Auction("Auction for fancy paintings", AuctionStatus.IN_PROGRESS),
            Auction("Auction for shows", AuctionStatus.NOT_STARTED),
        )), result)
    }

    @Test
    fun `returns empty list when response is not found`() {
        val handler = { _: Request -> Response(Status.NOT_FOUND)}

        val client = AuctionClient(handler)

        val result = client.auctionsCatalog()

        assertEquals(emptyList(), result.auctions)
    }

    @Test
    fun `client builds correct request to get auctions catalog`() {
        val actualRequest = mutableListOf<Request>()

        val expectedRequest = Request(
            method = Method.GET,
            uri = "https://www.auctions-catalog.com/catalog"
        )

        val handler = { request: Request ->
            actualRequest.add(request)

            Response(Status.OK).body("""
            [
              {
                "name": "Auction for pools",
                "startDate": "2025-11-08",
                "endDate": "2025-01-08",
                "status": "FINISHED"
              },
              {
                "name": "Auction for fancy paintings",
                "startDate": "2025-01-03",
                "endDate": "2025-01-11",
                "status": "IN_PROGRESS"
              },
              {
                "name": "Auction for shows",
                "startDate": "2025-02-05",
                "endDate": "2025-02-15",
                "status": "NOT_STARTED"
              }
            ]
        """.trimIndent())
        }

        val client = AuctionClient(handler)

        client.auctionsCatalog()

        assertEquals(expectedRequest, actualRequest.single())


    }

}

