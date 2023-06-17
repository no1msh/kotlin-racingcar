package domain.model

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (MIN_NUMBER..MAX_NUMBER).random()
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 9
    }
}
