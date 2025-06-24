fun main() {
    println("Welcome to the Kotlin CLI Utility!")
    println("Available commands: sum, conversion, factorial, exit")

    while (true) {
        print("Enter command: ")
        val command = readLine()?.trim()?.lowercase()

        when (command) {
            "sum" -> handleSum()
            "conversion" -> {
                println("Conversion function not implemented yet. Please check with your team.")
            }
            "factorial" -> {
                println("Factorial function not implemented yet. Please check with your team.")
            }
            "exit" -> {
                println("Goodbye!")
                break
            }
            else -> println("Invalid command. Please try again.")
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