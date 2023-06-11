package domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "55555"])
    fun `자동차의 이름의 길이는 최소 1글자부터 최대 5글자여야한다`(name: String) {
        // when
        val carName = CarName(name)

        // then
        assertThat(carName.value).isEqualTo(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "sixLen"])
    fun `자동차의 이름의 길이가 최소 길이보다 짧거나 최대 길이보다 길다면 예외처리한다`(carName: String) {
        // when
        val errorMessage = assertThrows<IllegalArgumentException> { CarName(carName) }.message

        // then
        assertThat(errorMessage).isEqualTo("[잘못된 이름: $carName] 자동차의 이름은 최소 1글자이며 최대 5글자를 넘지 않아야합니다.")
    }
}
