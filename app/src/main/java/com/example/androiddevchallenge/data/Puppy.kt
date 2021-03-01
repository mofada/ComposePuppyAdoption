package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    //宠物名
    val name: String,
    //宠物年龄, 月份
    val age: Float,
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
    val phoneNumber: String,
    //是否免费
    val isFree: Boolean,
    //金额
    val money: Float
) : Parcelable