package sum

/**
 * Returns sum of numbers cubed from 1 to n, with n being a natural number
 * E.g.     valid   sumCubes(2) = 9
 *                  sumCubes(3) = 36
 *          invalid sumCubes(0) = -1
 *                  sumCubes(-5) = -1
 *                  sumCubes(304) = -2
 *                  sumCubes(1290) = -2
 * @param   n natural number
 * @returns sum of numbers cubed from 1 to n, or -1 if n is not a natural number,
 *          or -2 if the calculation overflows int.max_value
 */
fun sumCubes(n: Int): Int {
    if (n < 1) return -1

    var sum: Int = 0
    for(i: Int in 1..n) {
        val tmpSum: Int = sum
        val tmpCube: Int = i * i * i

        if (tmpSum > (tmpSum + tmpCube)) {
            sum = -2
            break
        } else {
            sum += tmpCube
        }
    }

    return sum
}

fun handleSum(): Unit {
    println("The sum operation will calculate the sum of numbers cubed from 1 to n, where n is a natural number.")
    println("Please supply the value of n:")

    val n = readLine()

    if (n == null || n.isEmpty()) {
        return println("Error: Input was empty, this operation will terminate and return you to the main menu.")
    }

    val nNum = try { n.toInt() } catch (e: NumberFormatException) { -1 }
    val sum: Int = sumCubes(nNum)

    when (sum) {
        -1 -> return println("Error: Input was not a natural number, this operation will terminate and return you to the main menu.")
        -2 -> return println("Error: Input supplied was too large to be calculated, this operation will terminate and return you to the main menu.")
        else -> {
            println("The sum of cubes from 1 to $nNum is: ${sum}.")
            return println("Thank you for using the sum operation. You will now return to the main menu.")
        }
    }
}

fun main(): Unit = handleSum()