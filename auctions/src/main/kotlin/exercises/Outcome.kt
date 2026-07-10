package exercises

sealed class Outcome

data class Success(val value: String) : Outcome()

fun Outcome.outcomeMap(f: (String) -> String): Outcome {
    return if (this is Success)
        Success(f(value))
    else this
}

data class Failure(val value: String) : Outcome()
