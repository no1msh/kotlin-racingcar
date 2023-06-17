package racing.controller

import racing.model.Car
import racing.model.CarName
import racing.model.Racing
import racing.model.RandomNumberGenerator
import racing.view.InputView
import racing.view.OutputView

class RacingController {
    private val cars: List<Car> = initCars()
    private val lapTime: Int = initLapTime()
    private val racing: Racing by lazy {
        Racing(
            cars = cars,
            maxLapTimes = lapTime,
            numberGenerator = RandomNumberGenerator()
        )
    }

    fun startGame() {
        OutputView.printRacingResult()
        repeat(lapTime) {
            racing.raceOnce()
            OutputView.printCurrentProgress(cars)
        }
        OutputView.printWinners(racing.getWinnerNames())
    }

    private fun initCars(): List<Car> = runCatching {
        OutputView.printRequestCarNames()
        val carNames = InputView.requestCarNames()
        return carNames.map { Car(CarName(it)) }
    }
        .onFailure { OutputView.printExceptionMessage(it.message) }
        .getOrDefault(initCars())

    private fun initLapTime(): Int = runCatching {
        OutputView.printRequestLapTimes()
        return InputView.requestLapTimes() ?: throw IllegalArgumentException("1 이상의 정수값을 입력하세요.")
    }
        .onFailure { OutputView.printExceptionMessage(it.message) }
        .getOrDefault(initLapTime())
}
