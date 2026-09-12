package modern

/**
 * Lesson: data classes, value classes, objects, and sealed types.
 *
 * These are the Kotlin-first tools you will use most often on top of
 * classical OOP: immutable data holders, type-safe wrappers, singletons,
 * and closed hierarchies that `when` can check exhaustively.
 */
fun main() {
    val original = User(id = 1, name = "Halil", email = "halil@example.com")
    val renamed = original.copy(name = "Halil Ozel")
    val (id, name, email) = renamed
    println("User $id: $name <$email>")
    println("original == renamed: ${original == renamed}")

    val distance = Distance(1_500.0)
    println("Distance in km: ${distance.toKilometers()}")

    println(AppConfig.appName)
    println(EmptyResult)

    val results: List<OperationResult> = listOf(
        OperationResult.Success(42),
        OperationResult.Empty,
        OperationResult.Error("Division by zero"),
    )
    results.forEach { result -> println(describe(result)) }
}

data class User(
    val id: Int,
    val name: String,
    val email: String,
)

@JvmInline
value class Distance(val meters: Double) {
    fun toKilometers(): Double = meters / 1_000.0
}

object AppConfig {
    const val appName: String = "Kotlin Object-Oriented Programming"
}

data object EmptyResult

sealed interface OperationResult {
    data class Success(val value: Int) : OperationResult
    data object Empty : OperationResult
    data class Error(val message: String) : OperationResult
}

fun describe(result: OperationResult): String = when (result) {
    is OperationResult.Success -> "Success: ${result.value}"
    OperationResult.Empty -> "Empty result"
    is OperationResult.Error -> "Error: ${result.message}"
}
