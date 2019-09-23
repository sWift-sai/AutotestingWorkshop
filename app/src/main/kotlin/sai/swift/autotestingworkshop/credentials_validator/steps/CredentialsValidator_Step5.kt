package sai.swift.autotestingworkshop.credentials_validator.steps

class CredentialsValidator_Step5 {

    companion object {
        private const val PASSWORD_MIN_LENGTH = 4
        private const val PASSWORD_MAX_LENGTH = 12

        private val loginRegex = Regex("^[a-zA-Z-]{3,10}\$")
    }

    /**
     * Функция проверяет корректность логина.
     * Возвращает true, если логин имеет длину от 3 до 10 и содержит английские буквы и/или дефис
     */
    fun isLoginCorrect(login: String) = loginRegex matches login

    fun isPasswordCorrect(password: String): Boolean {
        return password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH
    }

}
