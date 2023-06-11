package domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        // given
        val carName = "name1"

        // when
        val car = Car(carName)

        // then
        assertThat(car.name).isEqualTo(carName)
    }

    @Test
    fun `자동차의 이름은 5글자를 넘지 않는다`() {
        // given
        val carName = "sixLen"

        // when
        val errorMessage = assertThrows<IllegalArgumentException> { Car(carName) }.message

        // then
        assertThat(errorMessage).isEqualTo("[잘못된 이름: $carName] 자동차의 이름은 5글자를 넘지 않아야합니다.")
    }
}
