package com.example.aplicacion_taller.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplicacion_taller.Components.CardViewHome
import com.example.aplicacion_taller.Components.CartButton
import com.example.aplicacion_taller.Components.MainScaffold
import com.example.aplicacion_taller.Components.SearchBarComponent
import com.example.aplicacion_taller.Components.Title
import com.example.aplicacion_taller.Components.cardCategoryHome
import com.example.aplicacion_taller.Components.spaceH
import com.example.aplicacion_taller.Components.spaceV
import com.example.aplicacion_taller.Data.database.AppDatabase
import com.example.aplicacion_taller.Data.repository.CategoryRepository
import com.example.aplicacion_taller.R
import com.example.aplicacion_taller.ViewModel.HomeViewModel
import com.example.aplicacion_taller.ViewModel.HomeViewModelFactory
import com.example.aplicacion_taller.ui.theme.Aplicacion_TallerTheme
import com.example.aplicacion_taller.ui.theme.ultra_l_blue
import com.example.aplicacion_taller.ui.theme.ultra_l_green
import com.example.aplicacion_taller.ui.theme.ultra_l_purple
import com.example.aplicacion_taller.ui.theme.ultra_l_red
import com.example.aplicacion_taller.ui.theme.ultra_l_yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit
) {
    MainScaffold(
        selectedItem = 0,
        onItemSelected = onItemSelected,
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Title(text = "Home View")
                    }
                    //colors = TopAppBarDefaults.topAppBarColors(
                    //containerColor = MaterialTheme.colorScheme.Red
                )
                //SearchBarComponent()
            }
        },
        floatingActionButton = {
            CartButton()
        }
    ) {padding ->
        ContentHomeView(Modifier.padding(padding))
    }
}

@Composable
fun ContentHomeView(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val categoryDao = database.categoryDao()
    val categoryRepository = CategoryRepository(categoryDao)
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(categoryRepository)
    )
    val categories by homeViewModel.categories.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp,
                end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardViewHome(
            "Frutas y verduras frescas",
            "20% de descuento en tu primera compra",
            stringResource(id = R.string.texto_boton),
            R.drawable.manzana
        )
        spaceV(16)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categorias",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ver todas",
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(categories) { category ->
                cardCategoryHome(
                    categoria = category.name,
                    imagen = category.image,
                    color = category.color
                )
                spaceH(6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview(){
    Aplicacion_TallerTheme{
        HomeView(
            modifier = Modifier,
            onItemSelected = { }
        )
    }
}