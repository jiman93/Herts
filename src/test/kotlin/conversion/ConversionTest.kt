package conversion

import kotlin.test.Test
import kotlin.test.assertEquals

class ConversionTest {
    @Test
    fun testCelsiusToKelvin() {
        assertEquals(273.15, celsiusToKelvin(0.0))
        assertEquals(373.15, celsiusToKelvin(100.0))
        assertEquals(-500.0, celsiusToKelvin(-275.0))
    }

    @Test
    fun testCelsiusToFahrenheit() {
        assertEquals(32.0, celsiusToFahrenheit(0.0))
        assertEquals(212.0, celsiusToFahrenheit(100.0))
        assertEquals(-500.0, celsiusToFahrenheit(-275.0))
    }

    @Test
    fun testKelvinToCelsius() {
        assertEquals(-273.15, kelvinToCelsius(0.0))
        assertEquals(-173.15, kelvinToCelsius(100.0))
        assertEquals(-500.0, kelvinToCelsius(-1.0))
    }

    @Test
    fun testKelvinToFahrenheit() {
        assertEquals(-459.67, kelvinToFahrenheit(0.0))
        assertEquals(-279.67, kelvinToFahrenheit(100.0))
        assertEquals(-500.0, kelvinToFahrenheit(-1.0))
    }

    @Test
    fun testFahrenheitToCelsius() {
        assertEquals(-17.78, fahrenheitToCelsius(0.0))
        assertEquals(37.78, fahrenheitToCelsius(100.0))
        assertEquals(-500.0, fahrenheitToCelsius(-460.0))
    }

    @Test
    fun testFahrenheitToKelvin() {
        assertEquals(255.37, fahrenheitToKelvin(0.0))
        assertEquals(310.93, fahrenheitToKelvin(100.0))
        assertEquals(-500.0, fahrenheitToKelvin(-460.0))
    }

    @Test
    fun testReturnTempUnit() {
        assertEquals("Celsius", returnTempUnit("c"))
        assertEquals("Kelvin", returnTempUnit("k"))
        assertEquals("Error", returnTempUnit(""))
        assertEquals("Error", returnTempUnit("Lorem"))
        assertEquals("Error", returnTempUnit(null))
    }

    @Test
    fun testTwoDecimalPlaces() {
        assertEquals(100.11, twoDecimalPlaces(100.11111111))
        assertEquals(1.57, twoDecimalPlaces(1.56546433))
    }

    @Test
    fun testisValidUnit() {
        assertEquals(true, isValidUnit("c"))
        assertEquals(true, isValidUnit("k"))
        assertEquals(true, isValidUnit("f"))
        assertEquals(false, isValidUnit("x"))
        assertEquals(false, isValidUnit(""))
        assertEquals(false, isValidUnit(null))
    }

    @Test
    fun testRunConversion() {
        assertEquals(32.0, runConversion("c", "f", 0.0))
        assertEquals(-279.67, runConversion("k", "f", 100.0))
        assertEquals(-500.0, runConversion("", "", 0.0))
        assertEquals(-500.0, runConversion("b", "k", 0.0))
        assertEquals(-500.0, runConversion("c", "f", -273.75))
        assertEquals(-500.0, runConversion(null, "f", -273.75))
    }
}