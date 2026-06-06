package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.WorkoutPlan
import com.example.ui.KineticViewModel
import com.example.ui.components.GlassCard
import com.example.ui.theme.*

@Composable
fun WorkoutScreen(
    viewModel:     KineticViewModel = viewModel(),
    onPlanClicked: (String) -> Unit
) {
    val plans            by viewModel.plans.collectAsState()
    val currentPlanIndex by viewModel.currentPlanIndex.collectAsState()
    val exercises        by viewModel.exercises.collectAsState()

    // Count exercises per plan for the card subtitle
    val countsByPlan = remember(exercises) {
        exercises.groupBy { it.planId }.mapValues { it.value.size }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Text("التمارين", style = MaterialTheme.typography.displayLarge, color = OnSurface, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("اختر برنامجك لتبدأ الجلسة", style = MaterialTheme.typography.bodyMedium, color = OnSurfaceVariant)
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(plans, key = { it.id }) { plan ->
            val isNext     = plans.indexOf(plan) == (currentPlanIndex % plans.size.coerceAtLeast(1))
            val exCount    = countsByPlan[plan.id] ?: 0
            PlanCategoryCard(
                plan       = plan,
                isNext     = isNext,
                exCount    = exCount,
                onClick    = { onPlanClicked(plan.id) }
            )
        }

        item {
            CardioCategoryCard(onClick = { onPlanClicked("cardio") })
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}

@Composable
fun PlanCategoryCard(
    plan:    WorkoutPlan,
    isNext:  Boolean,
    exCount: Int,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (isNext) Primary else SurfaceContainerHigh),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.FitnessCenter,
                        contentDescription = null,
                        tint     = if (isNext) Color.Black else OnSurfaceVariant,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(plan.name, style = MaterialTheme.typography.headlineMedium, color = OnSurface, fontWeight = FontWeight.Bold)
                        if (isNext) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Primary.copy(alpha = 0.15f))
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text("التالي", style = MaterialTheme.typography.labelSmall, color = Primary, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Text(
                        "$exCount تمارين",
                        style = MaterialTheme.typography.bodyMedium,
                        color = OnSurfaceVariant
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(if (isNext) Primary.copy(alpha = 0.15f) else SurfaceContainerHigh),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.ChevronRight, contentDescription = "Open", tint = if (isNext) Primary else OnSurfaceVariant)
            }
        }
    }
}

@Composable
fun CardioCategoryCard(onClick: () -> Unit) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(SurfaceContainerHigh),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.DirectionsRun, contentDescription = null, tint = OnSurfaceVariant, modifier = Modifier.size(24.dp))
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text("CARDIO", style = MaterialTheme.typography.headlineMedium, color = OnSurface, fontWeight = FontWeight.Bold)
                    Text("Zone 2 & HIIT", style = MaterialTheme.typography.bodyMedium, color = OnSurfaceVariant)
                }
            }
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(SurfaceContainerHigh),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.ChevronRight, contentDescription = "Open", tint = OnSurfaceVariant)
            }
        }
    }
}
