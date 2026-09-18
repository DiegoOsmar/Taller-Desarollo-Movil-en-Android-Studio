package com.example.aplicacion_taller.Data.repository

import com.example.aplicacion_taller.Data.dao.CategoryDao
import com.example.aplicacion_taller.Data.model.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun getCategories(): List<Category> {
        return categoryDao.getCategories()
    }
    suspend fun insertCategories(categories: List<Category>) {
        categoryDao.instertCategories(categories)
    }
    suspend fun countCategories(): Int {
        return categoryDao.countCategories()
    }
}