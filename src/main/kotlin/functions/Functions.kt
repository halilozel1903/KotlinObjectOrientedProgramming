package functions

/**
 * Lesson: functions in Kotlin.
 *
 * A function is a reusable block of code. Kotlin prefers expression bodies
 * for short functions, named arguments at call sites, and [readln] for
 * console input instead of the older `readLine()!!` idiom.
 */
fun main() {
    println("Main function: ${add(first = 12, second = 34)}")
    println("Hello, ${name("Halil")}")

    print("Enter a number to calculate its factorial: ")
    val number = readln().toInt()
    println("$number! = ${factorial(number)}")
}

/** Returns the sum of [first] and [second]. */
fun add(first: Int, second: Int): Int {
    val total = first + second
    println("add() result: $total")
    return total
}

/** Returns the given name. Short functions can use an expression body. */
fun name(value: String): String = value

/**
 * Calculates `n!` with an iterative loop.
 *
 * A more idiomatic alternative is `(1..n).fold(1) { acc, value -> acc * value }`.
 * The loop is kept here because it is easier to follow while learning.
 *
 * @throws IllegalArgumentException if [n] is negative
 */
fun factorial(n: Int): Int {
    require(n >= 0) { "Factorial is not defined for negative numbers: $n" }

    var result = 1
    for (counter in 1..n) {
        result *= counter
    }
    return result
}
