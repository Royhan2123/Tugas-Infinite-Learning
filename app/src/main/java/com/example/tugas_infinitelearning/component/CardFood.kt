package com.example.tugas_infinitelearning.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugas_infinitelearning.R
import com.example.tugas_infinitelearning.model.NameFood


@Composable
fun CardFood(
    nameFood: NameFood,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.height(225.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = nameFood.image),
                contentDescription = stringResource(
                    nameFood.nama
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(nameFood.nama),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
fun CardFoodPreview() {
    CardFood(
        nameFood = NameFood(
            R.string.name1,
            R.string.deskripsi1,
            R.drawable.nasi
        ),
    )
}