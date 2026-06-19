package exercises

sealed class Outcome

data class Success(val value: String): Outcome()

fun Success.outcomeMap(f: () -> String): Success{
    return Success(f())
}

data class Failure(val value: String): Outcome()
