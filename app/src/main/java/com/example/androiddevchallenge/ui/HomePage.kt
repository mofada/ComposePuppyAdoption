package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.DataViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomePage(navigateTo: (Screen) -> Unit) {
    val viewModel: DataViewModel = viewModel()
    MyTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Puppy", color = Color.White) })
            }
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(viewModel.puppies) { puppy ->
                    PuppyList(puppy, onItemClick = {
                        navigateTo(Screen.Detail(puppy = puppy))
                    })
                }
            }
        }
    }
}

@Composable
fun PuppyList(puppy: Puppy, onItemClick: (puppy: Puppy) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClick(puppy) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = puppy.avatar),
            contentDescription = puppy.name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier
                .weight(1f)
                .padding(start = 8.dp),
        ) {
            Text(text = puppy.name, fontSize = 18.sp, color = MaterialTheme.colors.onPrimary)
            Box(Modifier.height(4.dp))
            Text(text = puppy.breed, fontSize = 16.sp, color = MaterialTheme.colors.onSecondary)
        }

        Column(
        ) {
            Text(text = puppy.sex, fontSize = 16.sp, color = MaterialTheme.colors.onSecondary)
            Text(
                text = "${puppy.age} year",
                fontSize = 16.sp,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPuppyList() {
    val puppy = Puppy(
        "Luck",
        1,
        "girl",
        "金毛",
        R.drawable.german_shepherd,
        "可爱的金毛犬, 因为要回老家, 求好心人收留",
        "浙江省杭州市萧山区...",
        "13333333333"
    )
    PuppyList(puppy = puppy, onItemClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewPuppyListDark() {
    val puppy = Puppy(
        "Luck",
        1,
        "girl",
        "金毛",
        R.drawable.german_shepherd,
        "可爱的金毛犬, 因为要回老家, 求好心人收留",
        "浙江省杭州市萧山区...",
        "13333333333"
    )
    MyTheme(darkTheme = true) {
        PuppyList(puppy = puppy, onItemClick = {})
    }
}