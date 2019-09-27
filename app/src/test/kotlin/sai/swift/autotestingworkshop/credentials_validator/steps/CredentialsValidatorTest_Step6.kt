package sai.swift.autotestingworkshop.credentials_validator.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator

// Переделаем существующие тесты в параметрический тест
@RunWith(Parameterized::class)
class CredentialsValidatorTest_Step6(
    private val description: String,
    private val login: String,
    private val expectedResult: Boolean
) {

    companion object {
        @JvmStatic
        @Parameters(name = "while login {0} - should return {2}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("length is 3", "She", true),
                arrayOf(" length is 10", "Sherminato", true),
                arrayOf("contains '-'", "S-r", true),

                arrayOf("length < 3", "Sh", false),
                arrayOf("length > 10", "Sherminator", false),
                arrayOf("contains whitespace", "S r", false),
                arrayOf("contains russian letter", "Шer", false)
            )
        }
    }

    @Test
    fun `when isLoginCorrect `() {
        // given
        val validator = CredentialsValidator()

        // when
        val result = validator.isLoginCorrect(login)

        // then
        assertThat(result).isEqualTo(expectedResult)
    }

}
