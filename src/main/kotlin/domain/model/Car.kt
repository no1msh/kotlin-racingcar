package domain.model

class Car(
    val name: CarName,
    initPosition: Int = INIT_POSITION
) {
    var position = initPosition
        private set

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION) position++
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MOVE_CONDITION = 4
    }
}
