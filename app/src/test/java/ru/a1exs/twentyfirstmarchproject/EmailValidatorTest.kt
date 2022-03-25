package ru.a1exs.twentyfirstmarchproject

import junit.framework.Assert.assertEquals
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun checkEmptyEmail(){

        val email = ""
        val expected = EmailCheckerModel(false, "Email has not be empty")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutChar(){

        val email = "adsfjksldajf.com"
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutDot(){

        val email = "fasdljf@mailru"
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutCharAndDot(){

        val email = "lkjaflsdjkfmailru"
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutDomen(){

        val email = "ashdflkj@.com"
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutSubDomen(){

        val email = "alfjsdj@mail."
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkEmailWithoutName(){

        val email = "@mail.com"
        val expected = EmailCheckerModel(false, "Incorrect Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

    @Test
    fun checkCorrectEmail(){

        val email = "some@mail.ru"
        val expected = EmailCheckerModel(true, "Correct Email")
        val actual = EmailValidatorClass().checkEmail(email)

        assertEquals(expected, actual)

    }

}