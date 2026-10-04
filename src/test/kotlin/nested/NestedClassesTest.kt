package nested

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NestedClassesTest {
    @Test
    fun `warehouse report renders stocked quantities`() {
        val warehouse = Warehouse("North")
        warehouse.stock("Book A", quantity = 2)
        warehouse.stock("Book B", quantity = 1)

        val text = warehouse.createInventoryReport().render()
        assertEquals(true, text.contains("Book A: 2"))
        assertEquals(true, text.contains("Book B: 1"))
    }

    @Test
    fun `inner iterator walks cart items`() {
        val cart = ShoppingCart(owner = "Test")
        cart.addItem(name = "A", price = 1.0)
        cart.addItem(name = "B", price = 2.0)

        assertEquals(3.0, cart.total())

        val iterator = cart.itemIterator()
        assertEquals("A", iterator.next().name)
        assertEquals("B", iterator.next().name)
        assertFailsWith<IllegalStateException> {
            iterator.next()
        }
    }
}
