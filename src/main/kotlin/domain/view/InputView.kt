package domain.view

object InputView {
    fun requestCarNames(): List<String> {
        val input = readln()
        return input.split(",")
    }

    fun requestLapTimes(): Int? {
        val input = readln()
        return input.toIntOrNull()
    }
}
