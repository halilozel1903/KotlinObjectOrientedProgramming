package scope

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ScopeFunctionsTest {
    @Test
    fun `applyDiscount mutates order total`() {
        val order = Order(id = 1, total = 100.0)
        order.applyDiscount(rate = 0.2)
        assertEquals(80.0, order.total)
    }

    @Test
    fun `emailLabel returns null for blank input`() {
        assertNull(emailLabel(""))
        assertNull(emailLabel("   "))
    }

    @Test
    fun `emailLabel extracts local part`() {
        assertEquals("Alex", emailLabel("alex@example.com"))
    }

    @Test
    fun `apply configures user in place`() {
        val user = User(name = "Guest", email = "g@example.com").apply {
            emailVerified = true
        }
        assertTrue(user.emailVerified)
    }
}
