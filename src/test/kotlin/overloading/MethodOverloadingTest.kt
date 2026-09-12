package overloading

import kotlin.test.Test
import kotlin.test.assertEquals

class MethodOverloadingTest {
    @Test
    fun `sumWithDefaults covers two three and four arguments`() {
        assertEquals(15, sumWithDefaults(10, 5))
        assertEquals(18, sumWithDefaults(10, 5, 3))
        assertEquals(22, sumWithDefaults(10, 5, 3, 4))
    }

    @Test
    fun `sumAll accepts a variable number of values`() {
        assertEquals(21, intArrayOf(1, 2, 3, 4, 5, 6).sum())
    }
}
