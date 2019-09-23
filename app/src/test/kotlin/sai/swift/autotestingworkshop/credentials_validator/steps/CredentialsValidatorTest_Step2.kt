package sai.swift.autotestingworkshop.credentials_validator.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator

class CredentialsValidatorTest_Step2 {

    private val validator =
        CredentialsValidator()


    // region isLoginCorrect

    @Test
    fun `when isLoginCorrect - while login length is 3 - should return true`() {
        // when
        val result = validator.isLoginCorrect("She")

        // then
        assertThat(result).isTrue()
    }

    // endregion

}
