package delegation

import kotlin.test.Test
import kotlin.test.assertEquals

class DelegationTest {
    @Test
    fun `logging service delegates list to repository`() {
        val repository = InMemoryTaskRepository()
        val service = LoggingTaskService(repository)
        service.add(Task(id = 1, title = "One"))
        service.add(Task(id = 2, title = "Two"))

        assertEquals(listOf("One", "Two"), service.list().map { it.title })
    }

    @Test
    fun `observable counter notifies on change`() {
        val counter = ObservableCounter(initial = 0)
        val values = mutableListOf<Int>()
        counter.onChange = { values += it }
        counter.increment()
        counter.increment()

        assertEquals(listOf(1, 2), values)
        assertEquals(2, counter.value)
    }
}
