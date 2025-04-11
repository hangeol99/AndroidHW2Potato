package com.example.homework2.UIComponent

import android.content.res.Configuration
import android.view.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView

@Composable
fun CheckRotate(): Boolean {
    val rotation = LocalView.current.display?.rotation
    return rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180
}