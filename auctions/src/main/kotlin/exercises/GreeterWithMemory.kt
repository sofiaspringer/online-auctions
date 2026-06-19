package exercises

class GreeterWithMemory {
    val listOfNames = mutableListOf<String>()

    fun greet(name: String): String {
        if (listOfNames.contains(name)) return "Hello again, $name"
        else {
            listOfNames.add(name)
            return "Hello, $name"
        }
    }
}

