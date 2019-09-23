package sai.swift.autotestingworkshop.registration_viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sai.swift.autotestingworkshop.R
import sai.swift.autotestingworkshop.credentials_validator.CredentialsValidator
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Disabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.EnterButtonState.Enabled
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Default
import sai.swift.autotestingworkshop.registration_viewmodel.RegistrationViewState.Content.InputFieldState.Error

class RegistrationViewModel(
    private val context: Context,
    private val credentialsValidator: CredentialsValidator
) : ViewModel() {

    val liveState = MutableLiveData<RegistrationViewState>()

    private var contentState = RegistrationViewState.Content()
        set(value) {
            field = value
            liveState.value = field
        }


    /**
     * Функция вызывается при изменении логина или пароля пользователям.
     * [login] и [password] - новые значения логина и пароля.
     *
     * Если логин и/или пароль некорректны, состояние кнопки меняется на недоступное,
     * а состояния полей ввода логина и пароля - на соответствующие ошибке.
     * Если логин и пароль корректны, состояние кнопки меняется на доступное,
     * а состояния полей ввода - на дефолтные.
     *
     * Измененные состояния элементов View сохраняются в [liveState],
     * на изменения которого подписана View.
     */
    fun onCredentialsChanged(login: String, password: String) {
        val isLoginCorrect = credentialsValidator.isLoginCorrect(login)
        val isPasswordCorrect = credentialsValidator.isPasswordCorrect(password)

        val newLoginFieldState = if (isLoginCorrect) {
            Default
        } else {
            val errorMessage = context.getString(R.string.incorrect_login_error)
            Error(errorMessage)
        }

        val newPasswordFieldState = if (isPasswordCorrect) {
            Default
        } else {
            val errorMessage = context.getString(R.string.incorrect_password_error)
            Error(errorMessage)
        }

        val newEnterButtonState = if (isLoginCorrect && isPasswordCorrect) {
            Enabled
        } else {
            Disabled
        }

        contentState = contentState.copy(
            login = login,
            password = password,
            loginFieldState = newLoginFieldState,
            passwordFieldState = newPasswordFieldState,
            enterButtonState = newEnterButtonState
        )
    }

}
