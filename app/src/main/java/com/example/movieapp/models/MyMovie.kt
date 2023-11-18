package com.example.movieapp.models

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date

data class MyMovie(
    var name:String,
    var authors:String,
    var aboutMovie:String,
    var date:String = SimpleDateFormat("dd.MM.yyyy").format(Date())
):Serializable



