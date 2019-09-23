package sai.swift.autotestingworkshop.credentials_validator.steps

class CredentialsValidator_Step1 {

    companion object {
        private const val LOGIN_MIN_LENGTH = 3
        private const val LOGIN_MAX_LENGTH = 10

        private const val PASSWORD_MIN_LENGTH = 4
        private const val PASSWORD_MAX_LENGTH = 12
    }

    /**
     * Функция проверяет корректность логина.
     * Возвращает true, если логин имеет длину от 3 до 10 и содержит английские буквы и/или дефис
     */
    fun isLoginCorrect(login: String): Boolean {
        val forbiddenChar = login.firstOrNull { !it.isLetter() && it != '-' }

        return login.length in LOGIN_MIN_LENGTH..LOGIN_MAX_LENGTH
                && forbiddenChar == null
    }

    fun isPasswordCorrect(password: String): Boolean {
        return password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH
    }

}
