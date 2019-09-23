package sai.swift.autotestingworkshop.registration_viewmodel.steps

import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.Test
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewModel
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Enabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Default

// Пишем первый тест
class RegistrationViewModelTest_Step2 {

    companion object {
        const val CORRECT_LOGIN = "Android"
        const val INCORRECT_LOGIN = "RN"

        const val CORRECT_PASSWORD = "1337"
        const val INCORRECT_PASSWORD = "42"
    }


    @Test
    fun `when onCredentialsChanged - while credentials are correct - should enable enter button`() {
        // given
        val viewModel = RegistrationViewModel(
            context = mock(),
            credentialsValidator = CredentialsValidator()
        )

        // when
        viewModel.onCredentialsChanged(
            CORRECT_LOGIN,
            CORRECT_PASSWORD
        )

        // then
        val expectedState = Content(
            login = CORRECT_LOGIN,
            password = CORRECT_PASSWORD,
            loginFieldState = Default,
            passwordFieldState = Default,
            enterButtonState = Enabled
        )
        val state = viewModel.liveState.value

        assertThat(state).isEqualTo(expectedState)
    }

    @Test
    fun `when onCredentialsChanged - while login is incorrect - should disable enter button and show login error`() {
        fail("unimplemented")
    }

    @Test
    fun `when onCredentialsChanged - while password is incorrect - should disable enter button and show password error`() {
        fail("unimplemented")
    }

    @Test
    fun `when onCredentialsChanged - while credentials are incorrect - should disable enter button and show errors`() {
        fail("unimplemented")
    }

}
