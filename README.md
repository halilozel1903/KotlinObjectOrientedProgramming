# Kotlin: Object Oriented Programming

A small course project that introduces object-oriented programming constructs in **Kotlin**.

The original examples taught functions, a menu-driven calculator, and method overloading. Those lessons are still here. They now use current Kotlin idioms, English comments, and a Gradle build on **Kotlin 2.4.20** (K2 compiler) with **JDK 21**. Extra lessons cover classes, inheritance, and modern Kotlin types such as data classes and sealed interfaces.

## Requirements

- JDK 21 or newer (the Gradle toolchain downloads it if needed)
- No local Gradle install is required; use the wrapper

## Build and test

```bash
./gradlew test
```

## Run the lessons

```bash
./gradlew run                # lesson index
./gradlew runFunctions       # functions, input, and factorial
./gradlew runCalculator      # interactive calculator
./gradlew runOverloading     # method overloading and vararg
./gradlew runClasses         # classes, constructors, and properties
./gradlew runInheritance     # inheritance, interfaces, and polymorphism
./gradlew runDataClasses     # data classes, value classes, and sealed types
```

`runFunctions` and `runCalculator` read from standard input.

## Lessons

| Lesson | What you learn |
| --- | --- |
| [Functions](src/main/kotlin/functions/Functions.kt) | Named functions, expression bodies, `readln()`, and an iterative factorial |
| [Calculator](src/main/kotlin/calculator/Calculator.kt) | Functions used together, `when`, `java.time`, and an `enum class` menu |
| [Method overloading](src/main/kotlin/overloading/MethodOverloading.kt) | Overloads, `vararg`, and default parameters |
| [Classes and objects](src/main/kotlin/classes/ClassesAndObjects.kt) | Primary/secondary constructors, `init`, and properties |
| [Inheritance and interfaces](src/main/kotlin/inheritance/InheritanceAndInterfaces.kt) | `open`/`override`, abstract classes, interfaces, encapsulation |
| [Data and sealed classes](src/main/kotlin/modern/DataAndSealedClasses.kt) | `data class`, `value class`, `object`, sealed types, exhaustive `when` |

## Kotlin OOP notes

- Classes are `final` by default. Mark a type `open` or `abstract` before you inherit from it.
- Prefer a primary constructor with `val` / `var` properties over Java-style fields and setters.
- Use `data class` for values, `object` for singletons, and sealed types for closed hierarchies.
- Visibility modifiers (`private`, `protected`, `internal`) are the usual way to encapsulate state.
- A single `vararg` function or default arguments often replaces a long list of overloads.

## Project layout

```
src/main/kotlin/     Lesson sources (one package per example)
src/test/kotlin/     Unit tests for the non-interactive parts
gradle/              Version catalog and wrapper
```

## Resources

- [Kotlin documentation](https://kotlinlang.org/docs/home.html)
- [Object-oriented programming in Kotlin](https://kotlinlang.org/docs/classes.html)
- [What's new in Kotlin 2.4.20](https://kotlinlang.org/docs/whatsnew2420.html)
