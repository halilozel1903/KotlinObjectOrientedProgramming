package calculator

import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Lesson: functions working together in a small program.
 *
 * The original example was a menu-driven calculator. The same flow is kept,
 * but input uses [readln], time comes from `java.time`, and the menu options
 * are modeled as an [enum class] — a simple object-oriented type.
 */
fun main() {
    while (true) {
        val choice = showMenu() ?: continue
        if (choice == MenuOption.EXIT) break

        print("Enter the first number: ")
        val first = readln().toInt()
        print("Enter the second number: ")
        val second = readln().toInt()

        when (choice) {
            MenuOption.ADD -> println("Sum: ${add(first, second)}")
            MenuOption.SUBTRACT -> println("Difference: ${subtract(first, second)}")
            MenuOption.MULTIPLY -> println("Product: ${multiply(first, second)}")
            MenuOption.DIVIDE -> divide(first, second)
                ?.let { println("Quotient: $it") }
                ?: println("Cannot divide by zero.")
            MenuOption.EXIT -> Unit
        }
    }
}

enum class MenuOption(val code: Int) {
    ADD(1),
    SUBTRACT(2),
    MULTIPLY(3),
    DIVIDE(4),
    EXIT(5);

    companion object {
        fun from(code: Int): MenuOption? = entries.find { it.code == code }
    }
}

fun add(first: Int, second: Int): Int = first + second

fun subtract(first: Int, second: Int): Int = first - second

fun multiply(first: Int, second: Int): Int = first * second

/** Integer division. Returns `null` when [second] is zero. */
fun divide(first: Int, second: Int): Int? =
    if (second == 0) null else first / second

fun showMenu(): MenuOption? {
    val time = currentTime()
    println("----------- MENU  $time ------------")
    println("1 - Add")
    println("2 - Subtract")
    println("3 - Multiply")
    println("4 - Divide")
    println("5 - Exit")
    print("Your choice: ")

    val choice = readln().toIntOrNull()
    val option = choice?.let(MenuOption::from)
    if (option == null) {
        println("Invalid choice.")
    }
    return option
}

private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

fun currentTime(): String = LocalTime.now().format(timeFormatter)
