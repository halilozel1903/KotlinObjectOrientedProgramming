package app

/**
 * Default entry point for `./gradlew run`.
 *
 * Each lesson lives in its own package so it can keep a dedicated `main()`.
 * Use the Gradle tasks listed below to launch a specific example.
 */
fun main() {
    println(
        """
        Kotlin Object-Oriented Programming examples

        Run a lesson with Gradle:
          ./gradlew runFunctions      Functions, input, and factorial
          ./gradlew runCalculator     Interactive calculator
          ./gradlew runOverloading    Method overloading and vararg
          ./gradlew runClasses        Classes, constructors, and properties
          ./gradlew runInheritance    Inheritance, interfaces, and polymorphism
          ./gradlew runDataClasses    Data classes, value classes, and sealed types

        Or run the compiled classes directly after `./gradlew classes`.
        """.trimIndent()
    )
}
