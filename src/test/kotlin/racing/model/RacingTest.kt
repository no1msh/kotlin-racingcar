package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingTest {
    @Test
    fun `레이싱에 참가하는 자동차들을 가진다`() {
        // given
        val cars = listOf(Car(CarName("1")), Car(CarName("2")), Car(CarName("3")))

        // when
        val racing = Racing(cars) { 4 }

        // then
        assertThat(racing.cars).isEqualTo(cars)
    }

    @Test
    fun `레이싱을 1회씩 진행 시킬 수 있다`() {
        // given
        val cars = listOf(Car(CarName("1")), Car(CarName("2")), Car(CarName("3")))
        val racing = Racing(cars) { 4 }

        // when
        racing.raceOnce()

        // then
        assertAll(
            { assertThat(cars[0].position).isEqualTo(1) },
            { assertThat(cars[1].position).isEqualTo(1) },
            { assertThat(cars[2].position).isEqualTo(1) },
        )
    }

    @Test
    fun `제일 높은 포지션이 4인 우승자 자동차 1의 이름이 반환된다`() {
        // given
        val cars = listOf(
            Car(CarName("1"), 4),
            Car(CarName("2"), 3),
            Car(CarName("3"), 2)
        )
        val racing = Racing(cars) { 4 }

        // when
        val winnerNames = racing.getWinnerNames()

        // then
        assertThat(winnerNames).isEqualTo(listOf("1"))
    }

    @Test
    fun `제일 높은 포지션이 자동차 1과 자동차 2일 경우 1,2 모두 우승자이므로 같이 이름이 반환된다`() {
        // given
        val cars = listOf(
            Car(CarName("1"), 4),
            Car(CarName("2"), 4),
            Car(CarName("3"), 2)
        )
        val racing = Racing(cars) { 4 }

        // when
        val winnerNames = racing.getWinnerNames()

        // then
        assertThat(winnerNames).isEqualTo(listOf("1", "2"))
    }
}
