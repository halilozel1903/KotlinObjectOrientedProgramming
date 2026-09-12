package inheritance

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class InheritanceAndInterfacesTest {
    @Test
    fun `shapes calculate area polymorphically`() {
        val shapes: List<Shape> = listOf(Circle(5.0), Square(4.0))
        assertEquals(2, shapes.size)
        assertTrue(shapes[0].area() > 78.0)
        assertEquals(16.0, shapes[1].area())
    }

    @Test
    fun `bank account encapsulates the balance`() {
        val account = BankAccount(openingBalance = 100.0)
        account.deposit(50.0)
        account.withdraw(30.0)
        assertEquals(120.0, account.balance)
    }

    @Test
    fun `withdraw rejects amounts larger than the balance`() {
        val account = BankAccount(openingBalance = 10.0)
        assertFailsWith<IllegalArgumentException> {
            account.withdraw(20.0)
        }
    }
}
