package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    //宠物名
    val name: String,
    //宠物年龄
    val age: Int,
    //性别
    val sex: String,
    //宠物品种
    val breed: String,
    //图片
    @DrawableRes val avatar: Int,
    //描述文字
    val description: String,
    //位置
    val location: String,
    //电话
    val phoneNumber: String
) : Parcelable