package com.example.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.ui.theme.Surface
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val alpha by animateFloatAsState(
        targetValue   = 1f,
        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
        label         = "splash_alpha"
    )
    val scale by animateFloatAsState(
        targetValue   = 1f,
        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
        label         = "splash_scale"
    )

    LaunchedEffect(Unit) {
        delay(1600)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Surface),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter           = painterResource(id = R.drawable.ic_igym_logo),
            contentDescription = "IGYM",
            tint              = Color.Unspecified,
            modifier          = Modifier
                .size(160.dp)
                .alpha(alpha)
                .scale(scale)
        )
    }
}
