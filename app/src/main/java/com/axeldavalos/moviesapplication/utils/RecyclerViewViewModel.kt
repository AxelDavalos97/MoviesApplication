package com.axeldavalos.moviesapplication.utils

import androidx.lifecycle.ViewModel


abstract class RecyclerViewViewModel : ViewModel() {

    var eventHandler: RecyclerViewEventHandler? = null

}

interface RecyclerViewEventHandler