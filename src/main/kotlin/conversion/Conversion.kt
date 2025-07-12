package conversion

/**
 * Sentinel value representing an invalid temperature result.
 *
 * This constant is used across all temperature conversions
 * to signal errors such as:
 * - Input below absolute zero
 * - Unrecognized conversion units
 *
 * Chosen as it is lower than any valid result in Celsius, Kelvin, or Fahrenheit.
 */
val TEMP_ERROR: Double = -500.0


/**
 * Converts a temperature from celsius to kelvin
 * E.g.     valid   celsiusToKelvin(0.0) = 273.15
 *                  celsiusToKelvin(100.0) = 373.15
 *          invalid celsiusToKelvin(-275.0) = -500.0
 * @param   i greater than or equal to -273.75 (absolute zero)
 * @returns converted i value from celsius to kelvin, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute
 *          zero for all units, so it can never be returned)
 */
fun celsiusToKelvin(i: Double): Double {
    if (i < -273.15) return TEMP_ERROR

    return twoDecimalPlaces(i + 273.15)
}

/**
 * Converts a temperature from celsius to fahrenheit
 * E.g.     valid   celsiusToFahrenheit(0.0) = 32.0
 *                  celsiusToFahrenheit(100.0) = 212.0
 *          invalid celsiusToFahrenheit(-275.0) = -500.0
 * @param   i greater than or equal to -273.75 (absolute zero)
 * @returns converted i value from celsius to fahrenheit, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute zero
 *          for all units, so it can never be returned)
 */
fun celsiusToFahrenheit(i: Double): Double {
    if (i < -273.15) return TEMP_ERROR

    return twoDecimalPlaces((i * 9.0 / 5.0) + 32.0)
}

/**
 * Converts a temperature from kelvin to celsius
 * E.g.     valid   kelvinToCelsius(0.0) = -273.15
 *                  kelvinToCelsius(100.0) = -173.15
 *          invalid kelvinToCelsius(-1.0) = -500.0
 * @param   i greater than or equal to 0.0 (absolute zero)
 * @returns converted i value from kelvin to celsius, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute
 *          zero for all units, so it can never be returned)
 */
fun kelvinToCelsius(i: Double): Double {
    if (i < 0.0) return TEMP_ERROR

    return twoDecimalPlaces(i - 273.15)
}

/**
 * Converts a temperature from kelvin to fahrenheit
 * E.g.     valid   kelvinToFahrenheit(0.0) = -459.67
 *                  kelvinToFahrenheit(100.0) = -279.67
 *          invalid kelvinToFahrenheit(-1.0) = -500.0
 * @param   i greater than or equal to 0.0 (absolute zero)
 * @returns converted i value from kelvin to fahrenheit, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute zero
 *          for all units, so it can never be returned)
 */
fun kelvinToFahrenheit(i: Double): Double {
    if (i < 0.0) return TEMP_ERROR

    return twoDecimalPlaces((i - 273.15) * 9.0 / 5.0 + 32.0)
}

/**
 * Converts a temperature from fahrenheit to celsius
 * E.g.     valid   fahrenheitToCelsius(0.0) = -17.78
 *                  fahrenheitToCelsius(100.0) = 37.78
 *          invalid fahrenheitToCelsius(-460.0) = -500.0
 * @param   i greater than or equal to -459.67 (absolute zero)
 * @returns converted i value from fahrenheit to celsius, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute zero
 *          for all units, so it can never be returned)
 */
fun fahrenheitToCelsius(i: Double): Double {
    if (i < -459.67) return TEMP_ERROR

    return twoDecimalPlaces((i - 32.0) * 5.0 / 9.0)
}

/**
 * Converts a temperature from fahrenheit to kelvin
 * E.g.     valid   fahrenheitToKelvin(0.0) = 255.37
 *                  fahrenheitToKelvin(100.0) = 310.93
 *          invalid fahrenheitToKelvin(-460.0) = -500.0
 * @param   i greater than or equal to -459.67 (absolute zero)
 * @returns converted i value from fahrenheit to kelvin, or -500.0 if i is below absolute zero
 *          (-500.0 is used as the error code as it is below the lowest value of absolute zero
 *          for all units, so it can never be returned)
 */
fun fahrenheitToKelvin(i: Double): Double {
    if (i < -459.67) return TEMP_ERROR

    return twoDecimalPlaces((i - 32.0) * 5.0 / 9.0 + 273.15)
}

/**
 * Returns the full temperature name based on the abbreviation
 * E.g.     valid   returnTempUnit("c") = "Celsius"
 *                  returnTempUnit("k") = "Kelvin"
 *          invalid returnTempUnit("") = "Error"
 *                  returnTempUnit("lorem") = "Error"
 * @param   str value of the abbreviated temperature units ("c", "k" or "f")
 * @returns the full temperature name, or "Error" if str doesn't match the list of
 *          abbreviated units
 */
fun returnTempUnit(str: String): String = when (str) {
    "c" -> "Celsius"
    "k" -> "Kelvin"
    "f" -> "Fahrenheit"
    else -> "Error"
}

/**
 * Returns a double to two decimal places
 * E.g.     twoDecimalPlaces(100.11111111) = 100.11
 *          twoDecimalPlaces(1.56546433) = 1.57
 * @param   i number value to round
 * @returns a double to two decimal places
 */
fun twoDecimalPlaces(i: Double): Double = kotlin.math.round(i * 100.0) / 100.0

/**
 * Validates whether the given input is one of the accepted temperature units.
 * E.g.     valid   isValidUnit("c") = true
 *                  isValidUnit("k") = true
 *                  isValidUnit("f") = true
 *          invalid isValidUnit("x") = false
 *                  isValidUnit("") = false
 *                  isValidUnit(null) = false
 * @param   input nullable string representing temperature unit abbreviation
 * @returns true if input is "c", "k", or "f"; false otherwise
 */
fun isValidUnit(input: String?): Boolean {
    return input != null && input.isNotEmpty() &&
            (input == "c" || input == "k" || input == "f")
}

/**
 * Runs the specific temperature conversions based on the two abbreviated units and
 * the initial value
 * E.g.     valid   runConversion("c", "f", 0.0) = 32.0
 *                  runConversion("k", "f", 100.0) = -279.67
 *          invalid runConversion("", "", 0.0) = -500.0
 *                  runConversion("b", "k", 0.0) = -500.0
 *                  runConversion("c", "f", -273.75) = -500.0
 * @param   from value of the abbreviated temperature units ("c", "k" or "f")
 * @param   to value of the abbreviated temperature units ("c", "k" or "f")
 * @param   tempNumber initial value for conversion
 * @returns the value of the conversion, or -500.00 if from or to are empty, or -500.00
 *          if from or to do not match "c", "k" or "f", or -500.00 if tempNumber is
 *          below absolute zero
 */
fun runConversion(from: String, to: String, tempNumber: Double): Double =
    if (from == "c" && to == "k") celsiusToKelvin(tempNumber)
    else if (from == "c" && to == "f") celsiusToFahrenheit(tempNumber)
    else if (from == "k" && to == "c") kelvinToCelsius(tempNumber)
    else if (from == "k" && to == "f") kelvinToFahrenheit(tempNumber)
    else if (from == "f" && to == "c") fahrenheitToCelsius(tempNumber)
    else if (from == "f" && to == "k") fahrenheitToKelvin(tempNumber)
    else TEMP_ERROR

/**
 * Handles interaction with the user for the conversion operation
 * @returns Unit & multiple side effects of println and readLine
 */
fun handleConversion(): Unit {
    println("The temperature conversion operation will convert a temperature from Celsius, Kelvin, or Fahrenheit to another.")

    println("What do you want to convert from: c for Celsius, k for Kelvin, or f for Fahrenheit?")

    val from: String? = readLine()

    if (!isValidUnit(from)) {
        return println("Error: Input was invalid, this operation will terminate and return you to the main menu.")
    }

    println("What do you want to convert to: c for Celsius, k for Kelvin, or f for Fahrenheit?")

    val to: String? = readLine()

    if (!isValidUnit(to)) {
        return println("Error: Input was invalid, this operation will terminate and return you to the main menu.")
    } else if (from == to) {
        return println("Error: The units supplied were the same, this operation will terminate and return you to the main menu.")
    }

    // Assign to non-nullable variables after validation
    val fromUnit = from!!
    val toUnit = to!!

    println("What is the temperature?")

    val temp: String? = readLine()

    if (temp == null || temp.isEmpty()) {
        return println("Error: Input was empty, this operation will terminate and return you to the main menu.")
    }

    val tempNumber: Double = try { temp.toDouble() } catch (e: NumberFormatException) { TEMP_ERROR }

    if (tempNumber == TEMP_ERROR) {
        return println("Error: Input was invalid, this operation will terminate and return you to the main menu.")
    }

    var conversion: Double = runConversion(fromUnit, toUnit, tempNumber)

    if (conversion == TEMP_ERROR) {
        return println("Error: Conversion could not be performed, this operation will terminate and return you to the main menu.")
    }

    println("$tempNumber ${returnTempUnit(fromUnit)} is $conversion ${returnTempUnit(toUnit)}")

    return println("Thank you for using the temperature conversion operation. You will now return to the main menu.")
}

fun main(): Unit = handleConversion()