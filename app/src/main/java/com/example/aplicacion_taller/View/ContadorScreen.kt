package com.example.aplicacion_taller.View

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aplicacion_taller.ViewModel.ContadorViewModel

@Composable
fun ContadorScreen(
    viewModel: ContadorViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        //Mostrar en pantalla el valor actual del contador
        //Llamamos desde nuestra variable contador en el ViewModel
        Text(text="Contador ${viewModel.contador}")

        Button(
            onClick = {
                //La interfaz no modifica el contador
                //Solo le indica al viewModel que tiene que realizar
                viewModel.incrementar()
            }
        ) {
            Text("Incrementar")
        }
    }
}