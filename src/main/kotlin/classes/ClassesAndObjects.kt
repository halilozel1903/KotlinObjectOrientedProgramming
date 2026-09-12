package classes

import kotlin.math.PI

/**
 * Lesson: classes, objects, constructors, and properties.
 *
 * A class is a blueprint. Creating an instance (`Magazine()`, `Person(...)`)
 * produces an object. Kotlin primary constructors declare properties in one
 * line; `init` blocks run when the object is created.
 */
fun main() {
    val magazine = Magazine()
    magazine.showInformation()

    val player = FootballPlayer(name = "Halil", age = 22, team = "Turkey")
    println("${player.name} plays for ${player.team}")

    val circle = Circle(radius = 6.0)
    println("Circumference: ${circle.circumference}")
    println("Area: ${circle.area}")

    val fromParts = Person(firstName = "Halil", lastName = "Ozel")
    val fromFullName = Person("Yusuf Efe")
    fromParts.showInformation()
    fromFullName.showInformation()
}

class Magazine(
    val name: String = "How It Works",
    var issue: Int = 15,
) {
    fun showInformation() {
        println("Magazine name: $name")
        println("Magazine issue: $issue")
    }
}

class FootballPlayer(
    val name: String,
    val age: Int,
    val team: String,
) {
    init {
        println("Player created: $name, age $age, team $team")
    }
}

class Circle(
    private val radius: Double,
    private val pi: Double = PI,
) {
    val circumference: Double
        get() = 2 * pi * radius

    val area: Double
        get() = pi * radius * radius
}

class Person(val firstName: String, val lastName: String) {
    constructor(fullName: String) : this(
        firstName = fullName.substringBefore(" "),
        lastName = fullName.substringAfter(" "),
    )

    fun showInformation() {
        println("Name: $firstName")
        println("Surname: $lastName")
    }
}
