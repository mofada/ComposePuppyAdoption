package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Puppy

class DataViewModel : ViewModel() {
    val puppies by mutableStateOf(
        listOf(
            Puppy(
                "German shepherd",
                1,
                "boy",
                "German shepherd",
                R.drawable.german_shepherd,
                "The German Shepherd is a breed of dog. It was officially named the German Shepherd in 1977, so the names vary from place to place. In the Chinese context, it is often called German Wolfhound or German Wolfhound. The German Shepherd ranks third in the IQ ranking of all dogs.",
                "German",
                "0049  xxx xxxxxxxx"
            ),
            Puppy(
                "Bulldog",
                1,
                "boy",
                "Bulldog",
                R.drawable.bulldog,
                "The bulldog is a mammalian animal. It is a medium-sized dog breed, also known as tiger dog and bulldog. The term bulldog is usually used to refer to the English bulldog. The other bulldog breeds include American bulldogs, ancient English bulldogs, LeWitt Bulldog, Re-enacted English Bulldog, French Bulldog, etc.",
                "United Kingdom",
                "020 xxxx xxxx"
            )
        )
    )
}
