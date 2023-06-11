package domain.model

import java.util.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random().nextInt(RANDOM_RANGE)
    }

    companion object {
        private const val RANDOM_RANGE = 10
    }
}
