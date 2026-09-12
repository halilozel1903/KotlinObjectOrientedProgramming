package modern

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DataAndSealedClassesTest {
    @Test
    fun `data class copy and equality`() {
        val original = User(id = 1, name = "Halil", email = "halil@example.com")
        val renamed = original.copy(name = "Halil Ozel")

        assertEquals(original.id, renamed.id)
        assertEquals(original.email, renamed.email)
        assertNotEquals(original, renamed)
    }

    @Test
    fun `value class converts meters to kilometers`() {
        assertEquals(1.5, Distance(1_500.0).toKilometers())
    }

    @Test
    fun `sealed result descriptions are exhaustive`() {
        assertEquals("Success: 42", describe(OperationResult.Success(42)))
        assertEquals("Empty result", describe(OperationResult.Empty))
        assertEquals("Error: Division by zero", describe(OperationResult.Error("Division by zero")))
    }
}
