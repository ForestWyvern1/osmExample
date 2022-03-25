package ru.a1exs.twentyfirstmarchproject

import java.util.regex.Pattern

class EmailValidatorClass {

    private val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-z][a-z\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-z][a-z\\-]{0,2}" +
                ")+"
    )

    fun checkEmail(email: String): EmailCheckerModel {

        return when {
            email.isEmpty() -> {
                EmailCheckerModel(false, "Email has not be empty")
            }
            emailPattern.matcher(email).matches() -> {
                EmailCheckerModel(true, "Correct Email")
            }
            else -> {
                EmailCheckerModel(false, "Incorrect Email")
            }
        }

    }

}