package com.olajide.pinviewscreen.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olajide.pinviewscreen.data.PinActions

@Composable
fun PinButtons(
    style: TextStyle = TextStyle(fontSize = 24.sp, color = Color.Black),
    onActions: (PinActions) -> Unit
) {
    val rows = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf(" ", "0", "<")
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        rows.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { symbol ->
                    NumberButton(
                        modifier = Modifier,
                        symbol = symbol,
                        textStyle = style,
                        onClick = {
                            when (symbol) {
                                "<" -> onActions(PinActions.BackSpace)
                                " " -> {}
                                else -> onActions(PinActions.Number(symbol))
                            }
                        }
                    )
                }
            }
        }
    }
}
