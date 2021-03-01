/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
                TopAppBar(
                    title = {
                        Text(
                            text = "Puppy adoption",
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                )
            }
        ) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(viewModel.puppies) { puppy ->
                    PuppyList(
                        puppy,
                        onItemClick = {
                            navigateTo(Screen.Detail(puppy = puppy))
                        }
                    )
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
                text = if (puppy.isFree) "Free" else "Toll",
                fontSize = 16.sp,
                color = MaterialTheme.colors.onSecondary
            )
            Text(
                text = "$${puppy.money}",
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
        "Get rich",
        0f,
        "Female",
        "puppy",
        R.drawable.number_66928,
        "The whole family of adopters is required to love dogs. Please consider carefully whether the adopters will be able to stay the same from beginning to end, no matter what problems they encounter, including marriage, childbirth and relocation, the student party should not disturb, if you are the one, obtain the consent of the family before adoption. Never give up, seek medical treatment if you are sick, do not abuse, do not buy or sell. Get the vaccine on time. Work is stable and has a certain economic foundation.\n" +
            "Rescue near a trash can in the vegetable market. She was very timid and scared. She hid under the trash can shelf. The rescuer gave her food and drink every day. It slowly came out. It was also difficult to approach. Finally one day she became rich and began to trust her. He was successfully rescued. The rescuer gave Fa Cai a deworming vaccination and birth control operation. The dog is of iron-clad golden color, has dark and shiny hair, and has a particularly docile personality. A smart family member does not like to bark. Looking for someone to give him a home.\uD83D\uDE4F \uD83D\uDE4F \uD83D\uDE4F",
        "Jiujiang/Xunyang District",
        "66928",
        true, 0f
    )
    PuppyList(puppy = puppy, onItemClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewPuppyListDark() {
    val puppy = Puppy(
        "Get rich",
        0f,
        "Female",
        "puppy",
        R.drawable.number_66928,
        "The whole family of adopters is required to love dogs. Please consider carefully whether the adopters will be able to stay the same from beginning to end, no matter what problems they encounter, including marriage, childbirth and relocation, the student party should not disturb, if you are the one, obtain the consent of the family before adoption. Never give up, seek medical treatment if you are sick, do not abuse, do not buy or sell. Get the vaccine on time. Work is stable and has a certain economic foundation.\n" +
            "Rescue near a trash can in the vegetable market. She was very timid and scared. She hid under the trash can shelf. The rescuer gave her food and drink every day. It slowly came out. It was also difficult to approach. Finally one day she became rich and began to trust her. He was successfully rescued. The rescuer gave Fa Cai a deworming vaccination and birth control operation. The dog is of iron-clad golden color, has dark and shiny hair, and has a particularly docile personality. A smart family member does not like to bark. Looking for someone to give him a home.\uD83D\uDE4F \uD83D\uDE4F \uD83D\uDE4F",
        "Jiujiang/Xunyang District",
        "66928",
        true, 0f
    )
    MyTheme(darkTheme = true) {
        PuppyList(puppy = puppy, onItemClick = {})
    }
}
