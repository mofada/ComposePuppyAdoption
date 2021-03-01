package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Puppy

class DataViewModel : ViewModel() {
    val puppies by mutableStateOf(
        listOf(
            Puppy(
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
            ),
            Puppy(
                "Twist",
                0f,
                "Female",
                "puppy",
                R.drawable.d66927,
                "Occasionally encounter the small twist wandering outside, foraging for garbage to wrap his belly, carrying dog food to help him, he is very clever and clingy, and I hope to find a good owner who will never leave the beginning and end, give him a home, and no longer be insecure. The wandering and even being tortured and killed",
                "Jiujiang/Xunyang District",
                "66927",
                true, 0f
            ),
            Puppy(
                "Twist",
                0f,
                "Female",
                "puppy",
                R.drawable.d66919,
                "I found a dog girl on Kangwang Middle Road. She has clean ears, no skin disease, healthy, dewormed and vaccinated, and her personality is clingy and sensible. Friends who are interested hope to be inseparable to her under any circumstances. Abandoning the psychological preparation of taking care of it all the time, the family agrees that it is not adopted impulsively, not to abuse, not to buy or sell.",
                "Guangzhou/Liwan District",
                "66919",
                true, 0f
            ),
            Puppy(
                "Lucky",
                0f,
                "Male",
                "puppy",
                R.drawable.d66915,
                "Adopted in Shanghai, refused to share.",
                "Shanghai/Huangpu District",
                "66915",
                true, 0f
            ),
            Puppy(
                "Toho",
                0f,
                "Male",
                "puppy",
                R.drawable.d66912,
                "Adopted in Shanghai area and accept co-renting.",
                "Shanghai/Huangpu District",
                "66912",
                true, 0f
            ),
            Puppy(
                "Brother Poodle",
                0.5f,
                "Female",
                "Poodle",
                R.drawable.d66910,
                "Seriously looking for a home. Coyotito was born on 1.12. The three younger sisters have been adopted. The most handsome open-faced curly-haired brother is left. He is docile, shy and super friendly. Seeing strange cats and dogs, they are shaking their tails while trembling. Go to lick people ~ adopt instead of buying and selling pot friends! As long as you really raise it, you have been dewormed and took a bath to find a home carefully. The three sisters of the Coyote born on 1.12 have been adopted, and the most handsome open-faced curly brother is left, and has a docile personality. Shy and super friendly. Seeing strange cats and dogs shaking their tails and licking others~ Adopted instead of buying and selling pot friends! As long as you really raise them, the vaccine and deworming check are very healthy\uD83D\uDC36\uD83D \uDC97 \uD83D\uDC36\uD83D\uDC97\n" +
                        "Put a cute photo of childhood",
                "Beijing/Beijing",
                "66910",
                true, 0f
            ),
            Puppy(
                "Corgi",
                0.5f,
                "Male",
                "Corgi",
                R.drawable.d66911,
                "Wandering Corgi, I brought it back for inspection and there was no problem, but I was less courageous and didn't have the energy to find a good person",
                "Hangzhou/Hangzhou",
                "66911",
                true, 0f
            ),
            Puppy(
                "Qinqin",
                0f,
                "Female",
                "puppy",
                R.drawable.d66908,
                "Abandoned Rescue",
                "Shanghai Pudong New Area",
                "66908",
                true, 0f
            ),
            Puppy(
                "McGee",
                0f,
                "Female",
                "puppy",
                R.drawable.d66903,
                "The poor little dog rescued by breeding dogs, free adoption in Shanghai",
                "Shanghai Pudong New Area",
                "66903",
                true, 0f
            ),
            Puppy(
                "Niu Niu",
                0f,
                "Female",
                "puppy",
                R.drawable.d66904,
                "This dog may have been lost during estrus, and after a few days of prison meals, she happened to encounter a friend's dog who had gone missing. She saw it when she went to the police station to look for the dog, so she was rescued. She has been sterilized. My sister has a very good personality. She is fostered in a pet shop in Baoshan. Friends who intend to adopt her can go to the pet shop to see it. Thank you",
                "Shanghai Pudong New Area",
                "66904",
                true, 0f
            ),
            Puppy(
                "Little Yellow Yellow",
                0.5f,
                "Female",
                "puppy",
                R.drawable.d66901,
                "Little Huanghuang is a clever and clever baby, very clingy, well-behaved and cute. This summer we rescued a pregnant dog mother, and just delivered to the hospital, we gave birth to six baby dogs. This little yellow and yellow character follows his mother, Very well-behaved, very beautiful, shiny hair and healthy. Xiao Huang Huang is almost half a year old, it is very cute. Would you like to give him a warm home? Only for adoption in Beijing or Yanjiao.",
                "Beijing/Tongzhou District",
                "66901",
                true, 0f
            ),
            Puppy(
                "chocolate",
                0f,
                "Female",
                "puppy",
                R.drawable.d66896,
                "Work changes, frequent business trips, no company, free adoption",
                "Shanghai/Minhang District",
                "66896",
                true, 0f
            ),
        )
    )
}
