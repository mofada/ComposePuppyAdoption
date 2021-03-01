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

package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    // 宠物名
    val name: String,
    // 宠物年龄, 月份
    val age: Float,
    // 性别
    val sex: String,
    // 宠物品种
    val breed: String,
    // 图片
    @DrawableRes val avatar: Int,
    // 描述文字
    val description: String,
    // 位置
    val location: String,
    // 电话
    val phoneNumber: String,
    // 是否免费
    val isFree: Boolean,
    // 金额
    val money: Float
) : Parcelable
