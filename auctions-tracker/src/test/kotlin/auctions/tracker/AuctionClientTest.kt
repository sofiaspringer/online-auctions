package auctions.tracker

import org.http4k.core.Response
import org.http4k.core.Status
import kotlin.test.Test
import kotlin.test.assertEquals

class AuctionClientTest {
    @Test
    fun `reads auctions catalog`() {
        val client = AuctionClient()
        val response = Response(Status.OK).body("""
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

        val result = client.auctionsCatalog()

        assertEquals(AuctionsCatalog(listOf(
            Auction("Auction for pools", AuctionStatus.COMPLETED),
            Auction("Auction for fancy paintings", AuctionStatus.IN_PROGRESS),
            Auction("Auction for shows", AuctionStatus.NOT_STARTED),
        )), result)
    }
}