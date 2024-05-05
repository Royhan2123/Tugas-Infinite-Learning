package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.component.CardFood
import com.example.tugas_infinitelearning.model.NameFood
import com.example.tugas_infinitelearning.model.loadFood
import com.example.tugas_infinitelearning.navigation.NavigationScreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LazyGridPage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lazy Grid Page",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                )

            )
        }
    ) {
        Column (
            modifier = Modifier.padding(
                vertical = 50.dp,
                horizontal = 20.dp
            ),
        ) {
            ListFoodGrid(nameFoodList = loadFood(),navController)

        }

    }
}

@Composable
fun ListFoodGrid(
    nameFoodList: List<NameFood>,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(nameFoodList) { nameFood ->
            CardFood(nameFood = nameFood, modifier = Modifier
                .clickable {
                    navController.navigate(
                        route = "${NavigationScreen.Detailpage.name}/${nameFood.nama}"
                    )
                } )
        }
    }
}


@Preview
@Composable
fun PreviewLazyGridPage() {
    LazyGridPage(navController = rememberNavController())
}