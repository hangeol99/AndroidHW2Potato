package com.example.homework2.UIComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.homework2.Model.PotatoPart
import com.example.homework2.Model.allParts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PotatoApp() {
    val isPortrait = CheckRotate()

    var visibleParts by rememberSaveable(
        stateSaver = listSaver(
            save = { it.map { it.name } },
            restore = { names -> allParts.filter { it.name in names } }
        )
    ) {
        mutableStateOf(allParts)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 최상단 텍스트
        Text(
            text = "201912336 임한결",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        if (isPortrait) {
            PotatoImage(visibleParts = visibleParts, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            PotatoCheckBox(
                visibleParts = visibleParts,
                onToggle = { part, isChecked ->
                    visibleParts = if (isChecked) {
                        visibleParts + part
                    } else {
                        visibleParts - part
                    }
                }
            )
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
                PotatoImage(
                    visibleParts = visibleParts,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                PotatoCheckBox(
                    visibleParts = visibleParts,
                    onToggle = { part, isChecked ->
                        visibleParts = if (isChecked) {
                            visibleParts + part
                        } else {
                            visibleParts - part
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
            }
        }
    }
}