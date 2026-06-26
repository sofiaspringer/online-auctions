package auctions

class Greetings(val formal: Boolean) {

    fun hello(name: String): String =
        if (formal) { // Set a breakpoint here
            "Hello $name, how are you?"
        } else {
            "Hey $name, what's up?"
        }

    fun goodbye(name: String): String =
        if (formal) {
            "Goodbye $name."
        } else {
            "See ya $name!"
        }
}

interface Greeting {
    fun hello(name: String): String

    fun goodbye(name: String): String
}

object FormalGreeting : Greeting {
    override fun hello(name: String): String {
        return "Hello $name, how are you?"
    }

    override fun goodbye(name: String): String {
       return  "Goodbye $name."
    }

}

object InformalGreeting : Greeting {
    override fun hello(name: String): String {
        return "Hey $name, what's up?"
    }

    override fun goodbye(name: String): String {
        return "See ya $name!"
    }

}


fun main() {
    val greeting = Greetings(formal = true)
    val greeting1 = Greetings(formal = false)

    val name = "Alice" // Set a breakpoint here

    val message = greeting.hello(
        name
    )

    val hello = FormalGreeting.hello(name) // Set a breakpoint here
    val goodbye = InformalGreeting.goodbye(name)

    println(hello)
    println(goodbye)


//    println(message) // Set a breakpoint here
//    println(greeting1.goodbye(name))
}

object Greetings2 {
    fun hello(formal: Boolean, name: String): String =
        if (formal) { // Set a breakpoint here
            "Hello $name, how are you?"
        } else {
            "Hey $name, what's up?"
        }

    fun goodbye(formal: Boolean, name: String): String =
        if (formal) {
            "Goodbye $name."
        } else {
            "See ya $name!"
        }
}
