package overloading

/**
 * Lesson: method overloading and `vararg`.
 *
 * Overloading means the same function name can have several declarations
 * as long as the parameter lists differ (count or types). In modern Kotlin,
 * a single `vararg` function or default parameters often replaces a long
 * list of overloads — both styles are shown here.
 */
fun main() {
    sum(12, 34)
    sum(1, 3, 4)
    sum(9, 8, 7, 6)
    sumAll(1, 2, 3, 4, 5, 6)
    sum(1.2, 3.4)

    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    sum(numbers)

    // Named arguments and a default parameter can stand in for extra overloads.
    println("Sum with defaults: ${sumWithDefaults(first = 10, second = 5)}")
}

fun sum(numbers: Array<Int>) {
    println("Sum: ${numbers.sum()}")
}

fun sum(first: Int, second: Int) {
    println("Sum: ${first + second}")
}

fun sum(first: Double, second: Double) {
    println("Sum: ${first + second}")
}

fun sum(first: Int, second: Int, third: Int) {
    println("Sum: ${first + second + third}")
}

fun sum(first: Int, second: Int, third: Int, fourth: Int) {
    println("Sum: ${first + second + third + fourth}")
}

/**
 * `vararg` accepts any number of arguments. Inside the function the
 * parameter behaves like an [IntArray].
 */
fun sumAll(vararg values: Int) {
    println("Sum: ${values.sum()}")
}

fun sumWithDefaults(first: Int, second: Int, third: Int = 0, fourth: Int = 0): Int =
    first + second + third + fourth
