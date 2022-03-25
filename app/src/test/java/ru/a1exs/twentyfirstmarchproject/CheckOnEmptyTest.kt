package ru.a1exs.twentyfirstmarchproject

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class CheckOnEmptyTest {

    @Test
    fun checkEmpty() {
        val actual = CheckOnEmpty().checkEmpty("")
        assertFalse(actual)
    }

    @Test
    fun checkNotEmpty() {
        val actual = CheckOnEmpty().checkEmpty("notEmpty")
        assertTrue(actual)
    }
}