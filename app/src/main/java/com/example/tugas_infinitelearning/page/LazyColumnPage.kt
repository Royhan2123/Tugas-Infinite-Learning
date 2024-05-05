package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.tugas_infinitelearning.navigation.NavigationScreen
import com.example.tugas_infinitelearning.model.loadFood

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LazyColumnPage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lazy Column Page",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 60.dp,
                    horizontal = 20.dp
                ),
        ) {
            ListFood(nameFoodList = loadFood(), navController)
        }

    }
}

@Composable
fun ListFood(nameFoodList: List<NameFood>, navController: NavController) {
    LazyColumn {
        items(nameFoodList) { nameFood ->
            CardFood(nameFood = nameFood, modifier = Modifier.clickable {
                navController.navigate(
                    route = "${NavigationScreen.Detailpage.name}/${nameFood.nama}"
                )
            })
        }
    }
}

@Preview
@Composable
fun PreviewLazyColumnPage() {
    LazyColumnPage(navController = rememberNavController())
}