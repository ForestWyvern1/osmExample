package ru.a1exs.twentyfirstmarchproject

import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*

class DateFormattingClassTest {

    @Test
    fun checkCorrectDate(){

        val actual = DateFormattingClass().dateFormat("20030809")

        assertEquals("2003-08-09", actual)

    }

    @Test
    fun checkIncorrectDate(){

        val actual = DateFormattingClass().dateFormat("200308090909")

        assertEquals("2003-08-09", actual)

    }

}