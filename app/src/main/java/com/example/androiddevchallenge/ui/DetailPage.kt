package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import kotlinx.coroutines.launch

@Composable
fun DetailPage(puppy: Puppy, onBack: () -> Unit) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = puppy.name, color = MaterialTheme.colors.onPrimary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "back",
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "正在拨打电话 ${puppy.phoneNumber}",
                        actionLabel = "取消",
                        duration = SnackbarDuration.Indefinite
                    )
                }
            }, backgroundColor = MaterialTheme.colors.background) {
                Icon(
                    painterResource(id = R.drawable.ic_call),
                    contentDescription = "拨打电话",
                    tint = MaterialTheme.colors.onPrimary,
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CircleImage(
                    id = puppy.avatar,
                    contentDescription = puppy.name,
                    size = 200.dp,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }

            item {
                Text(text = puppy.name, fontSize = 24.sp, color = MaterialTheme.colors.onPrimary)
            }

            item {
                PrimaryInfo(puppy)
            }

            item { Divider(Modifier.padding(horizontal = 30.dp, vertical = 8.dp)) }

            item {
                Text(
                    text = "宠物介绍",
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                )
            }
            item {
                Text(
                    text = puppy.description,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 8.dp),
                )
            }
        }


    }
}

@Composable
private fun PrimaryInfo(puppy: Puppy) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PrimaryItem(title = "性别", content = puppy.sex, modifier = Modifier.weight(1f))
        Box(
            Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
        )
        PrimaryItem(
            title = "是否免费",
            content = if (puppy.isFree) "免费" else "收费",
            modifier = Modifier.weight(1f)
        )
        Box(
            Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
        )
        PrimaryItem(
            title = "金额",
            content = "￥${puppy.money}",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PrimaryItem(title: String, content: String, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = content, color = MaterialTheme.colors.onPrimary, fontSize = 16.sp)
        Box(Modifier.height(4.dp))
        Text(text = title, color = MaterialTheme.colors.onSecondary, fontSize = 12.sp)
    }
}

@Preview
@Composable
fun PreviewSecondaryItem() {
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
    PrimaryInfo(puppy = puppy)
}

@Preview
@Composable
fun PreviewDetail() {
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
    DetailPage(puppy = puppy, onBack = {})
}