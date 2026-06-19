package exercises

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GreeterWithMemoryTests {
    @Test
    fun `remember the person`(){
        val greeterWithMemory = GreeterWithMemory()

        assertEquals( "Hello, Alice", greeterWithMemory.greet("Alice"))
        assertEquals("Hello, Bob", greeterWithMemory.greet("Bob") )
        assertEquals("Hello again, Alice", greeterWithMemory.greet("Alice"))
    }
}
