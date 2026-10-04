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

        print("Birinci sayıyı giriniz : ")
        val first = readln().toInt()
        print("İkinci sayıyı giriniz : ")
        val second = readln().toInt()

        when (choice) {
            MenuOption.ADD -> println("Sayıların toplamı : ${add(first, second)}")
            MenuOption.SUBTRACT -> println("Sayıların cikarimi : ${subtract(first, second)}")
            MenuOption.MULTIPLY -> println("Sayıların carpımı : ${multiply(first, second)}")
            MenuOption.DIVIDE -> divide(first, second)
                ?.let { println("Sayıların bolumu : $it") }
                ?: println("Bölünen sayı sıfır olamaz !!")
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
    println("1 - Topla")
    println("2 - Çıkar")
    println("3 - Çarp")
    println("4 - Böl")
    println("5 - Cikis")
    print("Seçiminiz : ")

    val choice = readln().toIntOrNull()
    val option = choice?.let(MenuOption::from)
    if (option == null) {
        println("Hatalı giriş yaptınız !!!")
    }
    return option
}

private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

fun currentTime(): String = LocalTime.now().format(timeFormatter)
