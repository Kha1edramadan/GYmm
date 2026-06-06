package com.example.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.KineticViewModel
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.random.Random

// ─────────────────────────────────────────────────────────────────────────────

data class ConfettiPiece(
    val x: Float, val y: Float, val vx: Float, val vy: Float,
    val color: Color, val size: Float, val rotation: Float, val rotationSpeed: Float
)

@Composable
fun WorkoutCompletionScreen(
    sessionId: Long,
    planName: String,
    onDone: () -> Unit,
    viewModel: KineticViewModel = viewModel()
) {
    val allPRs        by viewModel.allPersonalRecords.collectAsState()
    val totalWorkouts by viewModel.totalWorkouts.collectAsState()

    val sessionPRs = remember(allPRs, sessionId) {
        allPRs.filter { it.achievedAt >= sessionId - 500 }
    }
    val durationMin = remember { ((System.currentTimeMillis() - sessionId) / 60000).toInt().coerceAtLeast(1) }

    // Static smart note
    val insight = remember(durationMin, sessionPRs.size, totalWorkouts) {
        defaultInsight(durationMin, sessionPRs.size, totalWorkouts)
    }

    // Confetti
    val confettiColors = listOf(Primary, Color(0xFF00C9FF), Color(0xFFFF6B6B),
        Color(0xFFFFD93D), Color(0xFF6BCB77), Color(0xFFFF922B))
    val pieces = remember {
        List(80) {
            ConfettiPiece(
                x = Random.nextFloat(), y = Random.nextDouble(-0.2, 0.0).toFloat(),
                vx = Random.nextDouble(-0.003, 0.003).toFloat(),
                vy = Random.nextDouble(0.004, 0.009).toFloat(),
                color = confettiColors.random(),
                size = Random.nextDouble(6.0, 14.0).toFloat(),
                rotation = Random.nextDouble(0.0, 360.0).toFloat(),
                rotationSpeed = Random.nextDouble(-3.0, 3.0).toFloat()
            )
        }
    }
    var tick by remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) { repeat(200) { delay(16); tick++ } }

    Box(modifier = Modifier.fillMaxSize().background(Surface)) {

        // ── Confetti Canvas ────────────────────────────────────────────────
        if (tick < 180) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                pieces.forEach { p ->
                    val newY = p.y + p.vy * tick
                    val newX = p.x + p.vx * tick
                    if (newY < 1.2f) {
                        drawRect(
                            color = p.color.copy(alpha = (1f - newY.coerceIn(0f, 1f)) * 0.9f),
                            topLeft = Offset(newX * size.width - p.size / 2, newY * size.height - p.size / 2),
                            size = androidx.compose.ui.geometry.Size(p.size, p.size * 0.6f)
                        )
                    }
                }
            }
        }

        // ── Content ────────────────────────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Trophy icon
            Box(
                modifier = Modifier.size(96.dp).clip(RoundedCornerShape(28.dp))
                    .background(Primary.copy(.15f)),
                contentAlignment = Alignment.Center
            ) { Text("🏋️", fontSize = 48.sp) }

            Spacer(Modifier.height(16.dp))
            Text("تمرين مكتمل!", style = MaterialTheme.typography.displayLarge.copy(fontSize = 30.sp),
                color = OnSurface, fontWeight = FontWeight.Bold)
            Text(planName, style = MaterialTheme.typography.bodyLarge, color = Primary)
            Spacer(Modifier.height(24.dp))

            // ── Stats Row ─────────────────────────────────────────────────
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CompletionStat("⏱", "${durationMin}د", "مدة",       Modifier.weight(1f))
                CompletionStat("🔥", "$totalWorkouts",  "تمرين كلي", Modifier.weight(1f))
                CompletionStat("🏆", "${sessionPRs.size}", "أرقام جديدة", Modifier.weight(1f))
            }

            // ── New PRs ───────────────────────────────────────────────────
            if (sessionPRs.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Column(
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp))
                        .background(Primary.copy(.08f)).padding(14.dp)
                ) {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Text("🏆  أرقام قياسية جديدة!",
                            style = MaterialTheme.typography.labelMedium, color = Primary,
                            fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        sessionPRs.forEach { pr ->
                            Row(Modifier.fillMaxWidth().padding(vertical = 3.dp),
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(pr.exerciseName, style = MaterialTheme.typography.bodySmall, color = OnSurface)
                                Text("${pr.weightKg}kg × ${pr.reps}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Primary, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // ── AI Smart Notes ────────────────────────────────────────────
            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
                    .background(SurfaceContainerHigh).padding(16.dp)
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(Icons.Default.Lightbulb, null,
                            tint = Primary, modifier = Modifier.size(16.dp))
                        Text("ملاحظات الجلسة",
                            style = MaterialTheme.typography.labelMedium,
                            color = Primary, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(10.dp))

                        Text(
                            insight,
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurface,
                            lineHeight = 22.sp
                        )
                }
            }

            Spacer(Modifier.height(32.dp))

            // ── Done Button ───────────────────────────────────────────────
            Button(
                onClick = onDone,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary, contentColor = Color.Black),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.Check, null, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text("رجوع للرئيسية",
                    style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun CompletionStat(emoji: String, value: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(14.dp))
            .background(SurfaceContainerHigh).padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 22.sp)
        Spacer(Modifier.height(4.dp))
        Text(value, style = MaterialTheme.typography.headlineMedium.copy(fontSize = 22.sp),
            color = OnSurface, fontWeight = FontWeight.Bold)
        Text(label, style = MaterialTheme.typography.labelSmall, color = OnSurfaceVariant)
    }
}
