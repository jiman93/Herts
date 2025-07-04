package sum

import kotlin.test.Test
import kotlin.test.assertEquals

class SumTest {
    @Test
    fun testSumCubes() {
        assertEquals(9, sumCubes(2))
        assertEquals(36, sumCubes(3))
        assertEquals(-1, sumCubes(0))
        assertEquals(-1, sumCubes(-5))
        assertEquals(-2, sumCubes(304))
        assertEquals(-2, sumCubes(1290))
    }
}