package ru.a1exs.twentyfirstmarchproject.model

data class RouteModel(

    val code : String,
    val waypoints : ArrayList<WayPointsModel>,
    val routes : ArrayList<RoutesModel>

)