package sai.swift.autotestingworkshop.credentials_validator.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator

// Добавим забытый тест на проверку допустимого языка логина
class CredentialsValidatorTest_Step4 {

    private val validator = CredentialsValidator()


    @Test
    fun `when isLoginCorrect - while login length is 3 - should return true`() {
        // when
        val result = validator.isLoginCorrect("She")

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `when isLoginCorrect - while login length is 10 - should return true`() {
        // when
        val result = validator.isLoginCorrect("Sherminato")

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `when isLoginCorrect - while login contains '-' - should return true`() {
        // when
        val result = validator.isLoginCorrect("S-r")

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `when isLoginCorrect - while login length is less than 3 - should return false`() {
        // when
        val result = validator.isLoginCorrect("Sh")

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `when isLoginCorrect - while login length is greater than 10 - should return false`() {
        // when
        val result = validator.isLoginCorrect("Sherminator")

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `when isLoginCorrect - while login contains whitespace - should return false`() {
        // when
        val result = validator.isLoginCorrect("S r")

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `when isLoginCorrect - while login contains russian letter - should return false`() {
        // when
        val result = validator.isLoginCorrect("Шer")

        // then
        assertThat(result).isFalse()
    }

}
