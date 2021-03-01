package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy

@Composable
fun DetailPage(puppy: Puppy, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = puppy.name, color = Color.White) }, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "back"
                    )
                }
            })
        }) {
        Column {
            Image(
                painter = painterResource(id = puppy.avatar),
                contentDescription = puppy.name,
                modifier = Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetail() {
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
    DetailPage(puppy = puppy, onBack = {})
}