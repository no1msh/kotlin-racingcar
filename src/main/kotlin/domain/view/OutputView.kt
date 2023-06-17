package domain.view

import domain.model.Car

object OutputView {
    private const val WINNER_NAMES_SEPARATOR = ", "
    private const val POSITION_DISPLAY = "-"

    fun printRequestCarNames() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printRequestLapTimes() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRacingResult() {
        println()
        println("실행 결과")
    }

    fun printCurrentProgress(cars: List<Car>) {
        cars.forEach {
            println("${it.name.value} : ${POSITION_DISPLAY.repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("최종 우승자: ${winnerNames.joinToString(WINNER_NAMES_SEPARATOR)}")
    }
}
