package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
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
        ListFoodGrid(nameFoodList = loadFood())
    }
}

@Composable
fun ListFoodGrid(
    nameFoodList: List<NameFood>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(nameFoodList) { nameFood ->
            CardFood(
                nameFood = nameFood,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewLazyGridPage() {
    LazyGridPage(navController = rememberNavController())
}