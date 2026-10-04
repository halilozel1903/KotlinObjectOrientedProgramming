package scope

/**
 * Lesson: scope functions — `let`, `run`, `with`, `apply`, and `also`.
 *
 * These standard-library extensions configure or transform an object inside a
 * short lambda. They are not a separate language feature, but they shape how
 * Kotlin code expresses fluent, object-oriented workflows without extra locals.
 */
fun main() {
    val user = User(name = "Alex", email = "alex@example.com")

    // `apply` — configure the receiver and return it (common for builders).
    val configured = User(name = "Guest", email = "guest@example.com").apply {
        emailVerified = true
    }
    println("Configured: $configured")

    // `also` — side effects while passing the same instance through a chain.
    val logged = user.also { println("Creating session for ${it.name}") }
    println("Same instance: ${logged === user}")

    // `let` — transform nullable or non-null values; result is the lambda return type.
    val domain = user.email.let { address -> address.substringAfter("@") }
    println("Email domain: $domain")

    // `run` — combine configuration and a computed result on the receiver.
    val greeting = user.run {
        "Hello, $name (${if (emailVerified) "verified" else "unverified"})"
    }
    println(greeting)

    // `with` — call several members without repeating the receiver name.
    val summary = with(user) {
        "$name <$email>"
    }
    println(summary)

    val orders = listOf(
        Order(id = 1, total = 120.0),
        Order(id = 2, total = 45.5),
    )
    orders.forEach { order ->
        order.applyDiscount(rate = 0.1)
            .also { discounted -> println("Order ${discounted.id} total: ${discounted.total}") }
    }
}

class User(var name: String, var email: String) {
    var emailVerified: Boolean = false
}

data class Order(val id: Int, var total: Double)

fun Order.applyDiscount(rate: Double): Order = apply {
    require(rate in 0.0..1.0) { "Discount rate must be between 0 and 1: $rate" }
    total *= (1.0 - rate)
}

/** Returns a display label or `null` when [email] is blank. */
fun emailLabel(email: String): String? = email.takeIf { it.isNotBlank() }?.let { value ->
    value.substringBefore("@").replaceFirstChar { it.uppercase() }
}
