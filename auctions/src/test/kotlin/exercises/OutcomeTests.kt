package exercises

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class OutcomeTests {
    @ParameterizedTest
    @MethodSource("onlyMapSuccess")
    fun `mapping only successes`(outcome: Outcome, expectedResult: Outcome){
        val result = outcome.outcomeSuccessesMap({ "$it nope" })
        assertEquals(expectedResult, result)
    }

    @ParameterizedTest
    @MethodSource("onlyMapFailures")
    fun `mapping only failures`(outcome: Outcome, expectedResult: Outcome){
        val result = outcome.outcomeFailuresMap({ "$it nope" })
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        private fun onlyMapSuccess(): Set<Arguments?> {
            return setOf(
                Arguments.of(Success("this is a success"), Success("this is a success nope")),
                Arguments.of(Failure("this is a failure"), Failure("this is a failure")),
            )
        }

        @JvmStatic
        private fun onlyMapFailures(): Set<Arguments?> {
            return setOf(
                Arguments.of(Success("this is a success"), Success("this is a success")),
                Arguments.of(Failure("this is a failure"), Failure("this is a failure nope")),
            )
        }
    }
}



