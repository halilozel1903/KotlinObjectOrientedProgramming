package classes

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals

class ClassesAndObjectsTest {
    @Test
    fun `magazine uses default property values`() {
        val magazine = Magazine()
        assertEquals("How It Works", magazine.name)
        assertEquals(15, magazine.issue)
    }

    @Test
    fun `circle exposes circumference and area as properties`() {
        val circle = Circle(radius = 6.0)
        assertEquals(2 * PI * 6.0, circle.circumference)
        assertEquals(PI * 36.0, circle.area)
    }

    @Test
    fun `secondary constructor splits a full name`() {
        val person = Person("Yusuf Efe")
        assertEquals("Yusuf", person.firstName)
        assertEquals("Efe", person.lastName)
    }
}
