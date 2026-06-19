package exercises

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class OutcomeTests {
    @Test
    fun `map success`() {
        val expected = "new value" + Random.nextInt().toString()
        val mappedSuccess = Success("this is a success")
            .outcomeMap({ expected })

        assertEquals(Success(expected), mappedSuccess)
    }
}



