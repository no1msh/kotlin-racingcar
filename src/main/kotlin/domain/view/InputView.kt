package domain.view

object InputView {
    fun requestCarNames(): List<String>? {
        val input = readlnOrNull()
        return input?.split(",")
    }

    fun requestLapTimes(): Int? {
        val input = readlnOrNull()
        return input?.toInt()
    }
}
