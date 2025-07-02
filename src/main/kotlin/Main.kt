import conversion.handleConversion
import factorial.handleFactorial

fun main() {
    var repeatCondition: Boolean = true

    println("Welcome to \"Interactive Kotlin Command-line Utility\" by Group B")
    println("This program can be used to complete three operations: sum, temperature conversion & factorials")

    while (repeatCondition) {
        println("To choose the sum operation, input \"sum\".")
        println("To choose the temperature conversion operation, input \"conversion\".")
        println("To choose the factorial operation, input \"factorial\".")
        println("To exit the program, input \"exit\".")

        val command = readLine()

        when (command) {
            "sum" -> handleSum()
            "conversion" -> handleConversion()
            "factorial" -> handleFactorial()
            "exit" -> {
                println("Thank you for using \"Interactive Kotlin Command-line Utility\" by Group B")
                println("Goodbye for now!")
                repeatCondition = false
            }
            else -> println("Error: Your input was invalid! Please try again.")
        }
    }
}

// sum: 1^3 + 2^3 + ... + n^3
fun handleSum() {
    print("Enter a natural number: ")
    val input = readLine()
    val n = input?.toIntOrNull()
    if (n == null || n <= 0) {
        println("Invalid input. Please enter a natural number.")
        return
    }

    val result = (1..n).sumOf { it * it * it }
    println("Sum of cubes up to $n is: $result")
}