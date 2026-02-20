package auctions.tracker

import org.http4k.core.HttpHandler
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
    fun test(){
        val bob = Bob({ "Bob" }, "da Silva")
        assertEquals("Bob da Silva", bob.fullName())
    }
}

class Bob(
    val firstName: () -> String,
    val lastName: String
){
    fun fullName(): String{
        return firstName() + lastName
    }
}

