package nested

/**
 * Lesson: nested and inner classes.
 *
 * A nested class is scoped inside its outer type and does not hold a reference
 * to the outer instance. An inner class is tied to a specific outer object and
 * can access its members — useful for builders and iterators tied to one owner.
 */
fun main() {
    val warehouse = Warehouse("Central")
    warehouse.stock("Kotlin in Action", quantity = 3)
    warehouse.stock("Effective Kotlin", quantity = 2)

    val snapshot = warehouse.createInventoryReport()
    println(snapshot.render())

    val cart = ShoppingCart(owner = "Alex")
    cart.addItem(name = "Notebook", price = 12.5)
    cart.addItem(name = "Pen", price = 2.0)
    println("Cart total for ${cart.owner}: ${cart.total()}")

    val iterator = cart.itemIterator()
    while (iterator.hasNext()) {
        println("  - ${iterator.next().name}")
    }
}

class Warehouse(private val name: String) {
    private val items = mutableMapOf<String, Int>()

    fun stock(title: String, quantity: Int) {
        items[title] = items.getOrDefault(title, 0) + quantity
    }

    fun createInventoryReport(): InventoryReport = InventoryReport(items.toMap())

    /** Nested class — no implicit reference to [Warehouse]. */
    class InventoryReport(private val snapshot: Map<String, Int>) {
        fun render(): String {
            val lines = snapshot.entries.joinToString(separator = "\n") { (title, qty) ->
                "  $title: $qty"
            }
            return "Inventory report\n$lines"
        }
    }
}

class ShoppingCart(val owner: String) {
    private val items = mutableListOf<LineItem>()

    data class LineItem(val name: String, val price: Double)

    fun addItem(name: String, price: Double) {
        items += LineItem(name, price)
    }

    fun total(): Double = items.sumOf { it.price }

    /** Inner class — each instance belongs to one [ShoppingCart]. */
    inner class ItemIterator(private var index: Int = 0) {
        fun hasNext(): Boolean = index < items.size

        fun next(): LineItem {
            if (!hasNext()) error("No more items in cart for $owner")
            return items[index++]
        }
    }

    fun itemIterator(): ItemIterator = ItemIterator()
}
