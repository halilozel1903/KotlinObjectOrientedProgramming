package functions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FunctionsTest {
    @Test
    fun `add returns the sum of two integers`() {
        assertEquals(46, add(12, 34))
    }

    @Test
    fun `name returns the given value`() {
        assertEquals("Halil", name("Halil"))
    }

    @Test
    fun `factorial of zero is one`() {
        assertEquals(1, factorial(0))
    }

    @Test
    fun `factorial of five is 120`() {
        assertEquals(120, factorial(5))
    }

    @Test
    fun `factorial rejects negative numbers`() {
        assertFailsWith<IllegalArgumentException> {
            factorial(-1)
        }
    }
}
