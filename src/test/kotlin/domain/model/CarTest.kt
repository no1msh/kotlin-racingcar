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

    @Test
    fun `자동차의 초기 위치값으로 아무것도 지정하지 않을시 기본 위치값은 0이다`() {
        // when
        val car = Car(CarName("test"))

        // then
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차는 무작위 값이 4이상이라면 전진할 수 있다`() {
        // given
        val car = Car(CarName("test"))

        // when
        car.move { 4 }

        // then
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차는 무작위 값이 4미만이라면 전진 할 수 없다`() {
        // given
        val car = Car(CarName("test"))

        // when
        car.move { 3 }

        // then
        assertThat(car.position).isEqualTo(0)
    }
}
