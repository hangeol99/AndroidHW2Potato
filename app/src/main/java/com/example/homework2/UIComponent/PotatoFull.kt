package com.example.homework2.UIComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter.State.Empty.painter
import com.example.homework2.Model.PotatoPart
import com.example.homework2.Model.allParts
import com.example.homework2.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun PotatoFull(modifier: Modifier = Modifier) {

    var visibleParts by rememberSaveable(
        stateSaver = listSaver(
            save = { it.map { it.name } },
            restore = { savedNames -> allParts.filter { it.name in savedNames } }
        )
    ) {
        mutableStateOf(allParts)
    }

    val portrait = CheckRotate()

    if (portrait) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize().padding(16.dp)
        ) {
            PotatoImage(visibleParts)
            Spacer(modifier = Modifier.height(16.dp))
            PotatoCheckBox(
                visibleParts = visibleParts,
                onToggle = { part, isChecked ->
                    visibleParts = if (isChecked) visibleParts + part else visibleParts - part
                }
            )
        }
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxSize().padding(16.dp)
        ) {
            PotatoImage(visibleParts)
            Spacer(modifier = Modifier.width(16.dp))
            PotatoCheckBox(
                visibleParts = visibleParts,
                onToggle = { part, isChecked ->
                    visibleParts = if (isChecked) visibleParts + part else visibleParts - part
                }
            )
        }
    }

}