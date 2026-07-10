package exercises

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class OutcomeTests {
    @ParameterizedTest
    @MethodSource("outcomes")
    fun `mapping only successes`(outcome: Outcome, expectedResult: Outcome){
        val result = outcome.outcomeMap({ "$it nope" })
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        private fun outcomes(): Set<Arguments?> {
            return setOf(
                Arguments.of(Success("this is a success"), Success("this is a success nope")),
                Arguments.of(Failure("this is a failure"), Failure("this is a failure")),
            )
        }
    }
}



