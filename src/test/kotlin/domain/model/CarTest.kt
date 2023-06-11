package domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        // given
        val carName = "name"

        // when
        val car = Car(carName)

        // then
        assertThat(car.name).isEqualTo(carName)
    }
}
