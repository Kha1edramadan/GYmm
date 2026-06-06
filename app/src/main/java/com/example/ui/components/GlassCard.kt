package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// ── Design tokens ─────────────────────────────────────────────────────────────
private val CardBg     = Color(0xFF161818)
private val CardBorder = Color(0xFFFFFFFF)
private val AccentLime = Color(0xFFC3F400)

// ── GlassCard ─────────────────────────────────────────────────────────────────
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    accentGlow: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    val glowColor = if (accentGlow) AccentLime.copy(alpha = 0.08f) else Color.Transparent

    Surface(
        modifier = modifier.drawBehind {
            // subtle lime glow at top-left corner
            if (accentGlow) {
                drawCircle(
                    color  = AccentLime.copy(alpha = 0.06f),
                    radius = size.width * 0.55f,
                    center = Offset(size.width * 0.15f, 0f)
                )
            }
        },
        shape         = RoundedCornerShape(20.dp),
        color         = CardBg,
        border        = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    CardBorder.copy(alpha = 0.14f),
                    CardBorder.copy(alpha = 0.04f),
                    CardBorder.copy(alpha = 0.10f)
                )
            )
        ),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.025f),
                            Color.Transparent
                        )
                    )
                )
                .padding(padding)
        ) {
            content()
        }
    }
}

// ── PrimaryGlowCard — used for highlighted/featured cards ────────────────────
@Composable
fun PrimaryGlowCard(
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF1A1E00),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    AccentLime.copy(alpha = 0.5f),
                    AccentLime.copy(alpha = 0.1f),
                    AccentLime.copy(alpha = 0.25f)
                )
            )
        )
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            AccentLime.copy(alpha = 0.07f),
                            Color.Transparent
                        ),
                        radius = 600f
                    )
                )
                .padding(padding)
        ) {
            content()
        }
    }
}
