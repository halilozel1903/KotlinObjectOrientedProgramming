package inheritance

import kotlin.math.PI

/**
 * Lesson: inheritance, interfaces, abstract classes, and polymorphism.
 *
 * Classes are `final` by default. Mark a type or member `open` (or `abstract`)
 * to allow overriding. Interfaces can declare properties and default methods.
 */
fun main() {
    val dog = Dog("Buddy")
    dog.makeSound()

    val shapes: List<Shape> = listOf(Circle(5.0), Square(4.0))
    shapes.forEach { shape -> println("${shape::class.simpleName} area: ${shape.area()}") }

    val car = Car(speed = 120.0)
    car.move()

    val account = BankAccount(openingBalance = 100.0)
    account.deposit(50.0)
    account.withdraw(30.0)
    println("Balance: ${account.balance}")
}

open class Animal(val name: String) {
    open fun makeSound() {
        println("$name makes a generic animal sound")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name: Woof!")
    }
}

abstract class Shape {
    abstract fun area(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
}

class Square(private val side: Double) : Shape() {
    override fun area(): Double = side * side
}

interface Movable {
    val speed: Double

    fun move() {
        println("Moving at $speed km/h")
    }
}

class Car(override val speed: Double) : Movable

/**
 * Encapsulation: [balance] is writable only inside this class.
 * Callers use [deposit] and [withdraw] instead of changing the field directly.
 */
class BankAccount(openingBalance: Double) {
    var balance: Double = openingBalance
        private set

    fun deposit(amount: Double) {
        require(amount > 0) { "Deposit must be positive" }
        balance += amount
    }

    fun withdraw(amount: Double) {
        require(amount > 0) { "Withdrawal must be positive" }
        require(amount <= balance) { "Insufficient funds" }
        balance -= amount
    }
}
