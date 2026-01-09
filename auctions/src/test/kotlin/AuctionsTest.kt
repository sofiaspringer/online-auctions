import auctions.Auction
import auctions.Auctions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.format.Moshi.json

class AuctionsTest {

    @Test
    fun `return auctions catalog`() {
        val auctions = Auctions()

        val response = auctions(Request(Method.GET, "catalog"))

        val jsonBody = response.json<List<Auction>>()
        assertEquals(response.status, OK)
        assertNotEquals(jsonBody, emptyList())
    }
}