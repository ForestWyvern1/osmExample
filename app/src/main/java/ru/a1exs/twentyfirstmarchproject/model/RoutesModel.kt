package ru.a1exs.twentyfirstmarchproject.model

data class RoutesModel(

    val legs : ArrayList<LegsModel>,
    val weight_name : String,
    val geometry : String,
    val weight : Double,
    val distance : Double,
    val duration : Double

)
