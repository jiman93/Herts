package factorial

import kotlin.test.Test
import kotlin.test.assertEquals

class FactorialTest {
    @Test
    fun testFactorial() {
        assertEquals(1, factorial(0))
        assertEquals(120, factorial(5))
        assertEquals(-1, factorial(-1))
        assertEquals(-1, factorial(13))
    }

    @Test
    fun testSumFactorial() {
        assertEquals(3, sumFactorial(0, 0, 0))
        assertEquals(9, sumFactorial(1, 2, 3))
        assertEquals(1437004800, sumFactorial(12, 12, 12))
        assertEquals(-1, sumFactorial(-1, 0, 0))
        assertEquals(-2, sumFactorial(13, 2, 3))
    }
}