package factorial

/**
 * Computes the factorial of x
 * E.g.     valid   factorial(0) = 1
 *                  factorial(5) = 120
 *          invalid factorial(-1) = -1
 *                  factorial(13) = -1
 * @param   x greater than or equal to 0
 * @returns factorial of x, or -1 if x is negative or the result overflows
 */
fun factorial(x: Int): Int {
    if (x < 0) return -1

    return if (x == 0) 1 else {
        val temp = factorial(x - 1)

        if (temp > (Int.MAX_VALUE / x)) -1 else x * temp
    }
}

/**
 * Computes the sum of the factorials of x, y & z
 * E.g.     valid   sumFactorial(0, 0, 0) = 1
 *                  sumFactorial(1, 2, 3) = 9
 *                  sumFactorial(12, 12, 12) = 1437004800
 *          invalid sumFactorial(-1, 0, 0) = ??
 *                  sumFactorial(13, 2, 3) = ??
 * @param   x greater than or equal to 0
 * @param   y greater than or equal to 0
 * @param   z greater than or equal to 0
 * @returns The sum of the factorials of x, y, z. Or -1 if the illegal arguments
 *          are supplied, or -2 if factorial of an argument overflows
 */
fun sumFactorial(x: Int, y: Int, z: Int): Int {
    if (x < 0 || y < 0 || z < 0) return -1

    val xFact: Int = factorial(x)
    val yFact: Int = factorial(y)
    val zFact: Int = factorial(z)

    if (xFact < 0 || yFact < 0 || zFact < 0) return -2

    return xFact + yFact + zFact
}

/**
 * Handles interaction with the user for the factorial operation
 * @returns Unit & multiple side effects of println and readline
 */
fun handleFactorial(): Unit {
    val arr: Array<Int> = Array<Int>(3) { -1 }
    var escape: Int = 0
    var sum: Int = 0

    println("The factorial operation will add the factorial of three numbers.")

    for (i: Int in 0..2) {
        println("Please supply ${if (i == 0) "a" else "another"} number:")
        val x = readLine()

        if (x == null || x.isEmpty()) {
            println("Error: Number was empty, this operation will terminate.")
            escape = -1
            break
        }

        arr[i] = try { x.toInt() } catch (e: NumberFormatException) { -1 }
    }

    if (escape == -1) return Unit

    sum = sumFactorial(arr[0], arr[1], arr[2])

    return when (sum) {
        -1 -> println("Error: The numbers supplied to the operation were not positive integers, this operation will terminate.")
        -2 -> println("Error: The numbers supplied were too large to be calculated, this operation will terminate.")
        else -> println("The sum of the factorials of ${arr[0]}, ${arr[1]} & ${arr[2]} is: $sum.\nThank you for using the factorial operation. You will now return to the main menu.")
    }
}

fun main(): Unit = handleFactorial()