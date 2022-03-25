package ru.a1exs.twentyfirstmarchproject

class DateFormattingClass {

    fun dateFormat(date: String): String {

        return "${date.take(4)}-${date.removeRange(0, 4).take(2)}-${date.removeRange(0, 6).take(2)}"

    }

}