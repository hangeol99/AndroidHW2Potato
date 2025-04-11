package com.example.homework2.UIComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.homework2.Model.PotatoPart
import com.example.homework2.Model.allParts

@Composable
fun PotatoCheckBox(visibleParts: List<PotatoPart>, onToggle: (PotatoPart, Boolean) -> Unit, modifier: Modifier = Modifier)
{
    val filteredParts = allParts.filter { it.name != "body" }
    val half = filteredParts.size / 2
    val leftList = filteredParts.subList(0, half)
    val rightList = filteredParts.subList(half, filteredParts.size)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(end = 24.dp)
        ) {
            leftList.forEach { part ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = part in visibleParts,
                        onCheckedChange = { isChecked -> onToggle(part, isChecked) },
                    )
                    Text(text = part.name)
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            rightList.forEach { part ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = part in visibleParts,
                        onCheckedChange = { isChecked -> onToggle(part, isChecked) },
                    )
                    Text(text = part.name)
                }
            }
        }
    }
}
