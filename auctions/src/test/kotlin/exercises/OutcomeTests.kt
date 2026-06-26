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

    @Test
    fun `map success with value` () {
        val initialResult = "this is a success" + Random.nextInt().toString()

        val success = Success(initialResult )
            .outcomeMap({it + "nope"})

        assertEquals(Success(initialResult + "nope"), success)
    }

    @Test
    fun `test`() {
       val failureOutput = Failure("this is a failure")
           .outcomeMap({"nope"})

        assertEquals(Failure("this is a failure"), failureOutput)

    }
}



