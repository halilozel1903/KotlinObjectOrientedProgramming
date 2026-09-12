plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

group = "com.halilozel"
version = "2.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        progressiveMode.set(true)
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass = "app.ExamplesKt"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

fun registerExample(taskName: String, main: String, description: String) {
    tasks.register<JavaExec>(taskName) {
        group = "application"
        this.description = description
        classpath = sourceSets["main"].runtimeClasspath
        mainClass = main
        standardInput = System.`in`
    }
}

registerExample("runFunctions", "functions.FunctionsKt", "Run the functions lesson")
registerExample("runCalculator", "calculator.CalculatorKt", "Run the calculator example")
registerExample("runOverloading", "overloading.MethodOverloadingKt", "Run the method overloading lesson")
registerExample("runClasses", "classes.ClassesAndObjectsKt", "Run the classes and objects lesson")
registerExample("runInheritance", "inheritance.InheritanceAndInterfacesKt", "Run the inheritance lesson")
registerExample("runDataClasses", "modern.DataAndSealedClassesKt", "Run the data and sealed classes lesson")
