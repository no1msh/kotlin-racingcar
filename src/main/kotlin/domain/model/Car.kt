package domain.model

data class Car(
    val name: String
) {
    init {
        require(name.length <= MAX_NAME_LENGTH) { "[잘못된 이름: $name] 자동차의 이름은 5글자를 넘지 않아야합니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
