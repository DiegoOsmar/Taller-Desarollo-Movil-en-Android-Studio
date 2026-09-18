package com.example.aplicacion_taller.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class ContadorViewModel: ViewModel() {
    //mutableStateOf indica que cuando el valor cambia, compose debe actualizarse
    var contador by mutableStateOf(0)
        //Indica que el valor solo puede modificarse en el ViewModel
        private set
    //Logica de incremento
    fun incrementar() {
        contador++
    }
}
