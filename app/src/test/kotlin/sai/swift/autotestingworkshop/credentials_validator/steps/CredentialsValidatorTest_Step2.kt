package sai.swift.autotestingworkshop.credentials_validator.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator

// Создаем тестовый класс и пишем первый тест на положительный кейс
class CredentialsValidatorTest_Step2 {

    private val validator = CredentialsValidator()


    @Test
    fun `when isLoginCorrect - while login length is 3 - should return true`() {
        // when
        val result = validator.isLoginCorrect("She")

        // then
        assertThat(result).isTrue()
    }

}
