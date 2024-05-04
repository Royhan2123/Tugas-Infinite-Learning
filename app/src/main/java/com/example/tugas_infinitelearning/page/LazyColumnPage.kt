package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.tugas_infinitelearning.model.DataNamaMakanan
import com.example.tugas_infinitelearning.model.NameFood

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
        ListFood(nameFoodList = DataNamaMakanan().loadFood())
    }
}

@Composable
fun ListFood(nameFoodList: List<NameFood>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(nameFoodList) { nameFoodList ->
            CardFood(
                navController = rememberNavController(),
                nameFood = nameFoodList,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewLazyColumnPage() {
    LazyColumnPage(navController = rememberNavController())
}