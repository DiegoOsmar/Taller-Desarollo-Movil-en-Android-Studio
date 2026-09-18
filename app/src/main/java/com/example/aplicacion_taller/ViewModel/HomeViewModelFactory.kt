package com.example.aplicacion_taller.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacion_taller.Data.repository.CategoryRepository

class HomeViewModelFactory(
    private val categoryRepository: CategoryRepository
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(
        //representa una instancia de la clase
        modelClass: Class<T>
    ):T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(
                categoryRepository
            )as T
        }
        throw IllegalArgumentException(
            "No existe el View Model"
        )
    }
}