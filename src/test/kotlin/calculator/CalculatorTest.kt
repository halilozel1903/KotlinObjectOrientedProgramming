package calculator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CalculatorTest {
    @Test
    fun `arithmetic operations match the original calculator`() {
        assertEquals(5, add(2, 3))
        assertEquals(-1, subtract(2, 3))
        assertEquals(6, multiply(2, 3))
        assertEquals(2, divide(8, 4))
    }

    @Test
    fun `divide by zero returns null`() {
        assertNull(divide(10, 0))
    }

    @Test
    fun `menu options map from their numeric codes`() {
        assertEquals(MenuOption.ADD, MenuOption.from(1))
        assertEquals(MenuOption.EXIT, MenuOption.from(5))
        assertNull(MenuOption.from(9))
    }
}
