package sai.swift.autotestingworkshop.registration_viewmodel

import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Disabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Default

sealed class RegistrationViewState {

    object Loading : RegistrationViewState()

    data class Content(
        val login: String = "",
        val password: String = "",
        val loginFieldState: InputFieldState = Default,
        val passwordFieldState: InputFieldState = Default,
        val enterButtonState: EnterButtonState = Disabled
    ) : RegistrationViewState() {

        sealed class InputFieldState {
            object Default : InputFieldState()

            data class Error(val message: String) : InputFieldState()
        }

        sealed class EnterButtonState {
            object Enabled : EnterButtonState()

            object Disabled : EnterButtonState()
        }

    }

}
