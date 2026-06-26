package exercises

sealed class Outcome

data class Success(val value: String): Outcome()


fun Success.outcomeMap(f: (String) -> String): Success{
    return Success( f(value))
}

fun Failure.outcomeMap(f: (String) -> String): Failure{
    return Failure( f(value))
}

data class Failure(val value: String): Outcome()
