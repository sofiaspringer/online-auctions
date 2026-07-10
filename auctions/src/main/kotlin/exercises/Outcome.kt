package exercises

sealed class Outcome {
    fun outcomeFailuresMap(function: (String) -> String): Outcome {
        return if (this is Failure)
            Failure(function(value))
        else this
    }
}

data class Success(val value: String) : Outcome()

fun Outcome.outcomeSuccessesMap(f: (String) -> String): Outcome {
    return if (this is Success)
        Success(f(value))
    else this
}

data class Failure(val value: String) : Outcome()
