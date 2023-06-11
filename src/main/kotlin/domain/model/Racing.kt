package domain.model

class Racing(
    val cars: List<Car>,
    private val maxLapTimes: Int = DEFAULT_LAP_TIMES,
    private val numberGenerator: NumberGenerator
) {
    var currentLap = 0
        private set

    fun raceOnce() {
        if (currentLap == maxLapTimes) return
        cars.forEach { it.move(numberGenerator) }
        currentLap++
    }

    fun getWinnerNames(): List<String> {
        val winnerPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == winnerPosition }
        return winners.map { it.name.value }
    }

    companion object {
        private const val DEFAULT_LAP_TIMES = 1
    }
}
