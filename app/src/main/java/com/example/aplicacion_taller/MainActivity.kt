package com.example.aplicacion_taller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacion_taller.View.ContadorScreen
import com.example.aplicacion_taller.View.HomeView
import com.example.aplicacion_taller.ViewModel.ContadorViewModel
import com.example.aplicacion_taller.ui.theme.Aplicacion_TallerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aplicacion_TallerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeView(modifier = Modifier.padding(innerPadding),
                        onItemSelected = {})
                }
            }
        }
    }
}
