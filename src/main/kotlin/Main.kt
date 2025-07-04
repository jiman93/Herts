import conversion.handleConversion
import factorial.handleFactorial
import sum.handleSum

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