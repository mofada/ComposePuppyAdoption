package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                TopAppBar(title = { Text(text = "宠物领养", color = MaterialTheme.colors.onPrimary) })
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
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { onItemClick(puppy) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleImage(id = puppy.avatar, contentDescription = puppy.name, size = 60.dp)

        Column(
            Modifier
                .weight(1f)
                .padding(start = 8.dp),
        ) {
            Text(text = puppy.name, fontSize = 18.sp, color = MaterialTheme.colors.onPrimary)
            Box(Modifier.height(4.dp))
            Text(text = puppy.sex, fontSize = 16.sp, color = MaterialTheme.colors.onSecondary)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (puppy.isFree) "免费" else "收费",
                fontSize = 16.sp,
                color = MaterialTheme.colors.onSecondary
            )
            Text(
                text = "￥${puppy.money}",
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
        "麻花",
        0f,
        "Female",
        "小狗",
        R.drawable.d66927,
        "偶遇小麻花在外面流浪，觅食垃圾裹腹，随身带的狗粮喂食救助，特别聪明粘人，希望给它找到一个不离不弃善始善终的好主人，给它一个家，不再居无定所流浪甚至被人虐杀",
        "九江/浔阳区",
        "66928",
        true, 0f
    )
    PuppyList(puppy = puppy, onItemClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewPuppyListDark() {
    val puppy = Puppy(
        "麻花",
        0f,
        "Female",
        "小狗",
        R.drawable.d66927,
        "偶遇小麻花在外面流浪，觅食垃圾裹腹，随身带的狗粮喂食救助，特别聪明粘人，希望给它找到一个不离不弃善始善终的好主人，给它一个家，不再居无定所流浪甚至被人虐杀",
        "九江/浔阳区",
        "66928",
        true, 0f
    )
    MyTheme(darkTheme = true) {
        PuppyList(puppy = puppy, onItemClick = {})
    }
}