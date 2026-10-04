package delegation

import kotlin.properties.Delegates

/**
 * Lesson: delegation in Kotlin — interface delegation with `by` and property delegates.
 *
 * Composition often beats deep inheritance trees. Kotlin lets a class forward
 * interface calls to a delegate instance, and property delegates encapsulate
 * lazy initialization and change notification.
 */
fun main() {
    val repository = InMemoryTaskRepository()
    val service = LoggingTaskService(delegate = repository)

    service.add(Task(id = 1, title = "Learn scope functions"))
    service.add(Task(id = 2, title = "Practice delegation"))
    println("Tasks: ${service.list().joinToString { it.title }}")

    val counter = ObservableCounter(initial = 0)
    counter.onChange = { value -> println("Counter is now $value") }
    counter.increment()
    counter.increment()

    val report by lazy { "Report for ${service.list().size} tasks" }
    println(report)
    println("Lazy property reused: $report")
}

interface TaskRepository {
    fun add(task: Task)
    fun list(): List<Task>
}

data class Task(val id: Int, val title: String)

class InMemoryTaskRepository : TaskRepository {
    private val tasks = mutableListOf<Task>()

    override fun add(task: Task) {
        tasks += task
    }

    override fun list(): List<Task> = tasks.toList()
}

/**
 * Forwards [TaskRepository] calls to [delegate] and adds logging around `add`.
 */
class LoggingTaskService(private val delegate: TaskRepository) : TaskRepository by delegate {
    override fun add(task: Task) {
        println("Adding task: ${task.title}")
        delegate.add(task)
    }
}

class ObservableCounter(initial: Int) {
    var value: Int by Delegates.observable(initial) { _, old, new ->
        if (old != new) {
            onChange?.invoke(new)
        }
    }

    var onChange: ((Int) -> Unit)? = null

    fun increment() {
        value += 1
    }
}
