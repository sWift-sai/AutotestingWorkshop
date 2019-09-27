package sai.swift.autotestingworkshop.registration_viewmodel.steps

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import sai.swift.autotestingworkshop.R
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewModel
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Disabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Enabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Default
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Error

// Реализуем остальные тесты (с мокированием функций)
class RegistrationViewModelTest_Step4 {

    // region Fields
    companion object {
        const val CORRECT_LOGIN = "Android"
        const val INCORRECT_LOGIN = "RN"

        const val CORRECT_PASSWORD = "1337"
        const val INCORRECT_PASSWORD = "42"

        const val LOGIN_ERROR_MESSAGE = "bad login"
        const val PASSWORD_ERROR_MESSAGE = "bad name"
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()
    // endregion


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
        // given
        val mockContext = mock<Context> {
            on { getString(R.string.incorrect_login_error) } doReturn (LOGIN_ERROR_MESSAGE)
        }
        val viewModel = RegistrationViewModel(
            context = mockContext,
            credentialsValidator = CredentialsValidator()
        )

        // when
        viewModel.onCredentialsChanged(
            INCORRECT_LOGIN,
            CORRECT_PASSWORD
        )

        // then
        val expectedState = Content(
            login = INCORRECT_LOGIN,
            password = CORRECT_PASSWORD,
            loginFieldState = Error(LOGIN_ERROR_MESSAGE),
            passwordFieldState = Default,
            enterButtonState = Disabled
        )
        val state = viewModel.liveState.value

        assertThat(state).isEqualTo(expectedState)
    }

    @Test
    fun `when onCredentialsChanged - while password is incorrect - should disable enter button and show password error`() {
        // given
        val mockContext = mock<Context> {
            on { getString(R.string.incorrect_password_error) } doReturn (PASSWORD_ERROR_MESSAGE)
        }
        val viewModel = RegistrationViewModel(
            context = mockContext,
            credentialsValidator = CredentialsValidator()
        )

        // when
        viewModel.onCredentialsChanged(
            CORRECT_LOGIN,
            INCORRECT_PASSWORD
        )

        // then
        val expectedState = Content(
            login = CORRECT_LOGIN,
            password = INCORRECT_PASSWORD,
            loginFieldState = Default,
            passwordFieldState = Error(PASSWORD_ERROR_MESSAGE),
            enterButtonState = Disabled
        )
        val state = viewModel.liveState.value

        assertThat(state).isEqualTo(expectedState)
    }

    @Test
    fun `when onCredentialsChanged - while credentials are incorrect - should disable enter button and show errors`() {
        // given
        val mockContext = mock<Context> {
            on { getString(R.string.incorrect_login_error) } doReturn (LOGIN_ERROR_MESSAGE)
            on { getString(R.string.incorrect_password_error) } doReturn (PASSWORD_ERROR_MESSAGE)
        }
        val viewModel = RegistrationViewModel(
            context = mockContext,
            credentialsValidator = CredentialsValidator()
        )

        // when
        viewModel.onCredentialsChanged(
            INCORRECT_LOGIN,
            INCORRECT_PASSWORD
        )

        // then
        val expectedState = Content(
            login = INCORRECT_LOGIN,
            password = INCORRECT_PASSWORD,
            loginFieldState = Error(LOGIN_ERROR_MESSAGE),
            passwordFieldState = Error(PASSWORD_ERROR_MESSAGE),
            enterButtonState = Disabled
        )
        val state = viewModel.liveState.value

        assertThat(state).isEqualTo(expectedState)
    }

}
