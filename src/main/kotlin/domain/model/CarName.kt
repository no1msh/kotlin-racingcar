package domain.model

data class CarName(
    val value: String
) {
    init {
        require(value.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            "[잘못된 이름: $value] 자동차의 이름은 최소 ${MIN_NAME_LENGTH}글자이며 최대 ${MAX_NAME_LENGTH}글자를 넘지 않아야합니다."
        }
    }

    companion object {
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
    }
}
