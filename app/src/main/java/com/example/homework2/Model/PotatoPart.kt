package com.example.homework2.Model

import androidx.compose.runtime.saveable.listSaver
import com.example.homework2.R

data class PotatoPart(val name:String, val resId: Int)

val allParts = listOf(
    PotatoPart("body", R.drawable.body),
    PotatoPart("arms", R.drawable.arms),
    PotatoPart("ears", R.drawable.ears),
    PotatoPart("eyebrows", R.drawable.eyebrows),
    PotatoPart("eyes", R.drawable.eyes),
    PotatoPart("glasses", R.drawable.glasses),
    PotatoPart("hat", R.drawable.hat),
    PotatoPart("mouth", R.drawable.mouth),
    PotatoPart("mustache", R.drawable.mustache),
    PotatoPart("nose", R.drawable.nose),
    PotatoPart("shoes", R.drawable.shoes),
)