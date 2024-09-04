package com.olajide.pinviewscreen.ui.presentation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    symbol: String,
    textStyle: TextStyle = TextStyle(fontSize = 24.sp, color = Color.Black),
    onClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 2f else 1f,
        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing)
    )

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                        onClick()
                    }
                )
            }
    ) {
        Text(
            text = symbol,
            fontSize = textStyle.fontSize,
            fontWeight = textStyle.fontWeight ?: FontWeight.Bold,
            color = textStyle.color,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = androidx.compose.ui.graphics.TransformOrigin(0.5f, 1f)
                }
                .padding(8.dp)
        )
    }
}
