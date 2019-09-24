package sai.swift.autotestingworkshop.credentials_validator.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator

// Переделаем существующие тесты в параметрический тест
@RunWith(Parameterized::class)
class CredentialsValidatorTest_Step6(
    private val login: String,
    private val expectedResult: Boolean
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("She", true),
                arrayOf("Sherminato", true),
                arrayOf("S-r", true),

                arrayOf("Sh", false),
                arrayOf("Sherminator", false),
                arrayOf("S r", false),
                arrayOf("Шer", false)
            )
        }
    }

    @Test
    fun `when isLoginCorrect`() {
        // given
        val validator = CredentialsValidator()

        // when
        val result = validator.isLoginCorrect(login)

        // then
        assertThat(result).isEqualTo(expectedResult)
    }

}
