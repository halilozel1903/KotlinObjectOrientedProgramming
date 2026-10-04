package functions

/**
 * Lesson: functions in Kotlin.
 *
 * A function is a reusable block of code. Kotlin prefers expression bodies
 * for short functions, named arguments at call sites, and [readln] for
 * console input instead of the older `readLine()!!` idiom.
 */
fun main() {
    println("Main metodu : ${add(first = 12, second = 34)}")
    println("Merhabalar ${name("Halil")}")

    print("Faktoriyeli hesaplanacak değeri giriniz : ")
    val number = readln().toInt()
    println("$number faktoriyeli : ${factorial(number)}")
}

/** Returns the sum of [first] and [second]. */
fun add(first: Int, second: Int): Int {
    val total = first + second
    println("Toplam metodu : $total")
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
