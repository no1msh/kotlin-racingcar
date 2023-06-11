package domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        // given
        val carName = "name1"

        // when
        val car = Car(name = CarName(carName))

        // then
        assertThat(car.name.value).isEqualTo(carName)
    }
}
