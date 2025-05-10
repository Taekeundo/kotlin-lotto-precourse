package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

import lotto.view.OutputView

fun main() {
    // Ask input(1)
    val purchaseAmount = readPurchaseAmount()

    // Calc & Generate tickets
    val nLottos : Int = purchaseAmount / 1000
    val listLottos = generateRandomSixDigitNumbers(nLottos)

    // Show results
    OutputView.printNumberOfTickets(nLottos)
    OutputView.printTicketsResult(listLottos)

    // Ask input(2)
    OutputView.ask2()
    val inputWinningNumbers = Console.readLine()
    validateWinningNumbers (inputWinningNumbers)
    val winningNumbers = inputWinningNumbers.split(",").map { it.trim().toInt() }

    // Ask input(3)
    OutputView.ask3()
    val inputBonusNumber = Console.readLine()
    validateBonusNumber (inputBonusNumber)
    val bonusNumber = inputBonusNumber.toInt()

    // Calc: check comparing winning+bonus number with Ticket numbers
    val resultMap = calcWinningStatus(listLottos, winningNumbers, bonusNumber)
    OutputView.printWinningStatistics(resultMap)

    // Calc: Check ratio of winning percentage
    val percentOfWinning = calcWinningPercent(resultMap, purchaseAmount)
    OutputView.printPercent(percentOfWinning)
}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            OutputView.ask1()
            val inputPurchaseAmount = Console.readLine()
            validatePurchaseAmount (inputPurchaseAmount)
            return inputPurchaseAmount.toInt()
        }
        catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun calcWinningPercent (resultMap: Map<String, Int>, purchaseAmount: Int) : Double {
    val prizeMoney = mapOf(
        "3" to 5000,
        "4" to 50000,
        "5" to 1500000,
        "5+" to 30000000,
        "6" to 2000000000
    )

    val totalWinning = resultMap.entries.sumOf { (rank, count) ->
        prizeMoney.getOrDefault(rank, 0) * count
    }

    val rate = totalWinning.toDouble() / purchaseAmount * 100
    return (rate)
}

fun calcWinningStatus(
    listLottos: List<List<Int>>,
    winningNumbers: List<Int>,
    bonusNumber: Int) : Map<String, Int> {
    val result = mutableMapOf<String, Int>()

    listLottos.forEach { oneLotto ->
        val matchCount = oneLotto.count { it in winningNumbers }
        val hasBonus = bonusNumber in oneLotto

        val rank = when {
            matchCount == 6 -> "6"
            matchCount == 5 && hasBonus -> "5+"
            matchCount == 5 -> "5"
            matchCount == 4 -> "4"
            matchCount == 3 -> "3"
            else -> null
        }

        if (rank != null) {
            result[rank] = result.getOrDefault(rank, 0) + 1
        }
    }
    return result
}

fun validatePurchaseAmount(input: String) {
    if (input.isEmpty()) {
        OutputView.printError("It must not be empty.")
        throw IllegalArgumentException()
    }
    if (!input.all { it.isDigit() }) {
        OutputView.printError("Amount must be numeric.")
        throw IllegalArgumentException()
    }
    if (input.length > 1 && input.startsWith("0")) {
        OutputView.printError("It must not start with 0.")
        throw IllegalArgumentException()
    }
    if (input.toInt() < 1000) {
        OutputView.printError("It must be greater than 1000.")
        throw IllegalArgumentException()
    }
    if (input.toInt() % 1000 != 0) {
        OutputView.printError("It must be divisible by 1000.")
        throw IllegalArgumentException()
    }
}

fun validateWinningNumbers(input: String) {
    if (input.isEmpty()) {
        OutputView.validateError1()
        throw IllegalArgumentException()
    }

    val numbers = input.split(",").map { it.trim() }

    if (numbers.any { it.any { ch -> !ch.isDigit() } }) {
        OutputView.validateError2()
        throw IllegalArgumentException()
    }

    if (numbers.any { it.length > 1 && it.startsWith("0") }) {
        OutputView.validateError3()
        throw IllegalArgumentException()
    }

    if (!input.contains(",")) {
        OutputView.validateError6()
        throw IllegalArgumentException()
    }

    if (numbers.size != 6) {
        OutputView.validateError7()
        throw IllegalArgumentException()
    }

    if (numbers.toSet().size != numbers.size) {
        OutputView.validateError8()
        throw IllegalArgumentException()
    }
}

fun validateBonusNumber(input: String) {
    if (input.isEmpty()) {
        OutputView.validateError1()
        throw IllegalArgumentException()
    }

    if (!input.all { it.isDigit() }) {
        OutputView.validateError2()
        throw IllegalArgumentException()
    }

    if (input.length > 1 && input.startsWith("0")) {
        OutputView.validateError3()
        throw IllegalArgumentException()
    }
}

fun generateRandomSixDigitNumbers(count: Int): List<List<Int>> {
    val numbers = mutableListOf<List<Int>>()
    repeat(count) {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        numbers.add(randomNumbers)
    }
    return numbers
}