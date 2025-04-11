package com.example.homework2.UIComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.homework2.Model.PotatoPart
import com.example.homework2.Model.allParts

@Composable
fun PotatoImage(visibleParts: List<PotatoPart>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(250.dp)
            .background(Color.White)
    ) {
        val body = allParts.find { it.name == "body" }
        body?.let {
            Image(
                painter = painterResource(id = it.resId),
                contentDescription = it.name,
                modifier = Modifier.fillMaxSize()
            )
        }
        visibleParts.filter { it.name != "body" }.forEach { part ->
            Image(
                painter = painterResource(id = part.resId),
                contentDescription = part.name,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}