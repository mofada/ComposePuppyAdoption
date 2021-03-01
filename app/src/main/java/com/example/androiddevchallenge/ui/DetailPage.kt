package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                        "Calling ${puppy.phoneNumber}",
                        actionLabel = "Cancel",
                        duration = SnackbarDuration.Indefinite
                    )
                }
            }, backgroundColor = MaterialTheme.colors.background) {
                Icon(
                    painterResource(id = R.drawable.ic_call),
                    contentDescription = "dial number",
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
                    text = "Puppy introduction",
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
        PrimaryItem(title = "Sex", content = puppy.sex, modifier = Modifier.weight(1f))
        Box(
            Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
        )
        PrimaryItem(
            title = "Is Free",
            content = if (puppy.isFree) "Free" else "Toll",
            modifier = Modifier.weight(1f)
        )
        Box(
            Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
        )
        PrimaryItem(
            title = "Money",
            content = "$${puppy.money}",
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
        "Get rich",
        0f,
        "Female",
        "puppy",
        R.drawable.d66928,
        "The whole family of adopters is required to love dogs. Please consider carefully whether the adopters will be able to stay the same from beginning to end, no matter what problems they encounter, including marriage, childbirth and relocation, the student party should not disturb, if you are the one, obtain the consent of the family before adoption. Never give up, seek medical treatment if you are sick, do not abuse, do not buy or sell. Get the vaccine on time. Work is stable and has a certain economic foundation.\n" +
                "Rescue near a trash can in the vegetable market. She was very timid and scared. She hid under the trash can shelf. The rescuer gave her food and drink every day. It slowly came out. It was also difficult to approach. Finally one day she became rich and began to trust her. He was successfully rescued. The rescuer gave Fa Cai a deworming vaccination and birth control operation. The dog is of iron-clad golden color, has dark and shiny hair, and has a particularly docile personality. A smart family member does not like to bark. Looking for someone to give him a home.\uD83D\uDE4F \uD83D\uDE4F \uD83D\uDE4F",
        "Jiujiang/Xunyang District",
        "66928",
        true, 0f
    )
    PrimaryInfo(puppy = puppy)
}

@Preview
@Composable
fun PreviewDetail() {
    val puppy = Puppy(
        "Get rich",
        0f,
        "Female",
        "puppy",
        R.drawable.d66928,
        "The whole family of adopters is required to love dogs. Please consider carefully whether the adopters will be able to stay the same from beginning to end, no matter what problems they encounter, including marriage, childbirth and relocation, the student party should not disturb, if you are the one, obtain the consent of the family before adoption. Never give up, seek medical treatment if you are sick, do not abuse, do not buy or sell. Get the vaccine on time. Work is stable and has a certain economic foundation.\n" +
                "Rescue near a trash can in the vegetable market. She was very timid and scared. She hid under the trash can shelf. The rescuer gave her food and drink every day. It slowly came out. It was also difficult to approach. Finally one day she became rich and began to trust her. He was successfully rescued. The rescuer gave Fa Cai a deworming vaccination and birth control operation. The dog is of iron-clad golden color, has dark and shiny hair, and has a particularly docile personality. A smart family member does not like to bark. Looking for someone to give him a home.\uD83D\uDE4F \uD83D\uDE4F \uD83D\uDE4F",
        "Jiujiang/Xunyang District",
        "66928",
        true, 0f
    )
    DetailPage(puppy = puppy, onBack = {})
}