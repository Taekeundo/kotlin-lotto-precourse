package lotto.view

object OutputView {

    fun ask1() {
        println("Please enter the purchase amount.")
    }

    fun ask2() {
        println("\nPlease enter last week's winning numbers.")
    }

    fun ask3() {
        println("\nPlease enter the bonus number.")
    }

    fun printError(message: String) {
        println("[ERROR] $message")
    }

    fun validateError1() {
        println("[ERROR] It must not be empty.")
    }

    fun validateError2() {
        println("[ERROR] Amount must be numeric.")
    }

    fun validateError3() {
        println("[ERROR] It must not start with 0.")
    }

    fun validateError4() {
        println("[ERROR] It must be greater than 1000.")
    }

    fun validateError5() {
        println("[ERROR] It must be divisible by 1000.")
    }

    fun validateError6() {
        println("[ERROR] Winning numbers must be separated by commas.")
    }

    fun validateError7() {
        println("[ERROR] Winning numbers must contain exactly 6 numbers separated by commas.")
    }

    fun validateError8() {
        println("[ERROR] Winning numbers must not contain duplicates.")
    }



    fun printNumberOfTickets(nLottos: Int) {
        println("\nYou have purchased $nLottos tickets.")
    }

    fun printWinningStatistics(result: Map<String, Int>) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result.getOrDefault("3", 0)} tickets")
        println("4 Matches (50,000 KRW) – ${result.getOrDefault("4", 0)} tickets")
        println("5 Matches (1,500,000 KRW) – ${result.getOrDefault("5", 0)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result.getOrDefault("5+", 0)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result.getOrDefault("6", 0)} tickets")
    }

    fun printPercent (percentOfWinning : Double) {
        val formatted = String.format("%.1f", percentOfWinning)
        println("Total return rate is $formatted%.")
    }

    fun printTicketsResult ( listLottos: List<List<Int>> ) {
        listLottos.forEach { println(it) }
    }
}