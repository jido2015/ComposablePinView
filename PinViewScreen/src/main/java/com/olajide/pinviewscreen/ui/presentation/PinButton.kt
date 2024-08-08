package com.olajide.pinviewscreen.ui.presentation

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    symbol: String,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(targetValue = if (isPressed) 1.1f else 1f)

    Box(
        modifier = modifier
            .size(90.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clip(RoundedCornerShape(100.dp))
            .clickable {
                isPressed = true
                onClick()
                isPressed = false
            }
    ) {
        TextButton(
            onClick = {  onClick()  },
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .then(modifier)) {
            Text(
                text = symbol,
                color = systemColor(),
                style = textStyle
            )
        }
    }
}


