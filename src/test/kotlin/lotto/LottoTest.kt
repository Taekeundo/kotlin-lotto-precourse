package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {
    @Test
    fun `givenLessThanSixNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `givenMoreThanSixNumbers_whenCreateLotto_thenThrowException`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `givenDuplicatedNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `givenOutOfRangeNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }
}