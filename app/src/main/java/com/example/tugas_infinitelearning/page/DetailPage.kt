package com.example.tugas_infinitelearning.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.R
import com.example.tugas_infinitelearning.model.loadFood

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailPage(navController: NavController, foodId: String?) {
    val newFood = loadFood().find { food ->
        food.nama.toString() == foodId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                },
                backgroundColor = Color.Gray,
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }

            )
        }
    ) {
        newFood?.let { nameFood ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = nameFood.image),
                    contentDescription = stringResource(nameFood.nama),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = nameFood.nama),
                        modifier = Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = stringResource(id = nameFood.deskripsi),
                        modifier = Modifier.padding(bottom = 32.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailPreview() {
    DetailPage(navController = rememberNavController(), foodId = stringResource(R.string.name1))
}