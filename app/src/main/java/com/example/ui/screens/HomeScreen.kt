package com.example.ui.screens

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.WorkoutSession
import com.example.ui.KineticViewModel
import com.example.ui.SittingReminderWorker
import com.example.ui.components.GlassCard
import com.example.ui.components.PrimaryGlowCard
import com.example.ui.theme.*

@Composable
fun HomeScreen(
    onStartWorkout: (String) -> Unit = {},
    viewModel: KineticViewModel = viewModel()
) {
    val plans            by viewModel.plans.collectAsState()
    val currentPlanIndex by viewModel.currentPlanIndex.collectAsState()
    val activePlan       = plans.getOrNull(currentPlanIndex % plans.size.coerceAtLeast(1))

    val targetCals  by viewModel.targetCals.collectAsState()
    val targetPro   by viewModel.targetPro.collectAsState()
    val targetCarbs by viewModel.targetCarbs.collectAsState()
    val targetFats  by viewModel.targetFats.collectAsState()

    val todayLogs     by viewModel.todayNutritionLogs.collectAsState()
    val consumedCals  = todayLogs.sumOf { it.calories }
    val consumedPro   = todayLogs.sumOf { it.protein.toDouble() }.toInt()
    val consumedCarbs = todayLogs.sumOf { it.carbs.toDouble() }.toInt()
    val consumedFats  = todayLogs.sumOf { it.fat.toDouble() }.toInt()

    val workoutsThisWeek by viewModel.workoutsThisWeek.collectAsState()
    val elapsedWeeks     by viewModel.planElapsedWeeks.collectAsState()
    val planGoal         by viewModel.planGoal.collectAsState()
    val totalWorkouts    by viewModel.totalWorkouts.collectAsState()

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFF131515),
                        0.35f to Color(0xFF111313),
                        1.0f to Color(0xFF0D0F0F)
                    )
                )
            )
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(28.dp))
            HomeHeader(elapsedWeeks, planGoal, context)
        }
        item { SittingReminderToggleCard(context) }
        item { CurrentPhaseCard(planGoal, elapsedWeeks, workoutsThisWeek) }
        item {
            TodaysWorkoutCard(
                planName      = activePlan?.name ?: "—",
                exerciseCount = 7,
                onStart       = { activePlan?.let { onStartWorkout(it.id) } }
            )
        }
        item { EnergyHomeCard(consumed = consumedCals, target = targetCals) }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                MacroHomeCard("بروتين", consumedPro,   targetPro,   "g", Modifier.weight(1f))
                MacroHomeCard("كارب",   consumedCarbs, targetCarbs, "g", Modifier.weight(1f))
                MacroHomeCard("دهون",   consumedFats,  targetFats,  "g", Modifier.weight(1f))
            }
        }
        item { WeeklyCalendarCard(recentSessions = viewModel.recentSessions.collectAsState().value) }
        item { SubscriptionReminderCard(viewModel) }
        item { AppGuideCard() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
    }
}

// ── Header ─────────────────────────────────────────────────────────────────────
@Composable
private fun HomeHeader(week: Int, goal: String, context: Context) {
    // Infinite subtle pulse on the glow
    val infiniteTransition = rememberInfiniteTransition(label = "glow")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.10f, targetValue = 0.18f,
        animationSpec = infiniteRepeatable(tween(3200, easing = EaseInOutSine), RepeatMode.Reverse),
        label = "glowAlpha"
    )
    // Subtle horizontal shift animation for the glow orb
    val glowShift by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 18f,
        animationSpec = infiniteRepeatable(tween(4500, easing = EaseInOutSine), RepeatMode.Reverse),
        label = "glowShift"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                // Properly anchored ambient lime glow — sits in the top-right corner
                val cx = size.width - 48f + glowShift
                val cy = size.height * 0.3f
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFC3F400).copy(glowAlpha), Color.Transparent),
                        center = Offset(cx, cy),
                        radius = 260f
                    ),
                    radius = 260f,
                    center = Offset(cx, cy)
                )
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Column {
                // Accent label
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(Primary)
                    )
                    Text(
                        text          = "IGYM  •  UPPER LOWER SPLIT",
                        style         = MaterialTheme.typography.labelSmall.copy(letterSpacing = 1.2.sp),
                        color         = Primary.copy(0.85f)
                    )
                }
                Spacer(Modifier.height(6.dp))
                // Gradient title
                Text(
                    text = "الأسبوع $week",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        brush = Brush.horizontalGradient(
                            colors = listOf(OnSurface, OnSurface.copy(0.6f))
                        )
                    ),
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text  = goal,
                    style = MaterialTheme.typography.bodyMedium,
                    color = OnSurfaceVariant
                )
            }
            // Avatar / profile pill
            Box(
                modifier = Modifier
                    .height(42.dp)
                    .clip(RoundedCornerShape(21.dp))
                    .background(Color(0xFF1A1C1C))
                    .border(1.dp,
                        Brush.linearGradient(listOf(Color.White.copy(0.12f), Color.White.copy(0.04f))),
                        RoundedCornerShape(21.dp))
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.Bolt, null, tint = Primary, modifier = Modifier.size(14.dp))
                    Text("Active", style = MaterialTheme.typography.labelSmall, color = OnSurface)
                }
            }
        }
    }
}

// ── Sitting Reminder Toggle ────────────────────────────────────────────────────
@Composable
private fun SittingReminderToggleCard(context: Context) {
    var isActive by remember {
        mutableStateOf(SittingReminderWorker.isScheduled(context))
    }
    val bgColor by animateColorAsState(
        targetValue = if (isActive) Color(0xFF0A2A1A) else Color(0xFF161818),
        animationSpec = tween(400), label = "bg"
    )
    val accentColor = if (isActive) Color(0xFF34D399) else OnSurfaceVariant

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(
                1.dp,
                if (isActive) Color(0xFF34D399).copy(0.35f) else Color.White.copy(0.06f),
                RoundedCornerShape(16.dp)
            )
            .clickable {
                isActive = !isActive
                if (isActive) SittingReminderWorker.schedule(context)
                else          SittingReminderWorker.cancel(context)
            }
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment     = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(accentColor.copy(0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(if (isActive) "🚶" else "🪑", style = MaterialTheme.typography.bodyMedium)
                    }
                    Column {
                        Text(
                            text = if (isActive) "تذكير الحركة شغّال" else "تذكير الحركة",
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurface,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = if (isActive) "هيجيلك إشعار كل 30 دقيقة" else "إشعار كل 30 دقيقة لما تقعد على اللاب",
                            style = MaterialTheme.typography.labelSmall,
                            color = accentColor.copy(0.7f)
                        )
                    }
                }
                // Toggle switch
                Box(
                    modifier = Modifier
                        .width(46.dp)
                        .height(26.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(if (isActive) Color(0xFF34D399).copy(0.9f) else Color(0xFF2A2C2C)),
                    contentAlignment = if (isActive) Alignment.CenterEnd else Alignment.CenterStart
                ) {
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}

// ── Current Phase ─────────────────────────────────────────────────────────────
@Composable
private fun CurrentPhaseCard(goal: String, elapsedWeeks: Int, weeklyWorkouts: Int) {
    PrimaryGlowCard(modifier = Modifier.fillMaxWidth()) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment     = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text          = "CURRENT CYCLE",
                        color         = Primary.copy(0.7f),
                        style         = MaterialTheme.typography.labelSmall.copy(letterSpacing = 1.2.sp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text       = goal,
                        style      = MaterialTheme.typography.headlineMedium.copy(
                            brush = Brush.horizontalGradient(
                                listOf(OnSurface, OnSurface.copy(0.7f))
                            )
                        ),
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text  = "كل 4 تمارين مكتملين = أسبوع واحد",
                        style = MaterialTheme.typography.bodySmall,
                        color = OnSurfaceVariant
                    )
                    Spacer(Modifier.height(12.dp))
                    // Progress dots for this week
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        repeat(4) { i ->
                            Box(
                                modifier = Modifier
                                    .size(if (i < weeklyWorkouts) 10.dp else 8.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (i < weeklyWorkouts) Primary
                                        else Color.White.copy(0.1f)
                                    )
                            )
                        }
                        Text(
                            text = " $weeklyWorkouts/4 الأسبوع",
                            style = MaterialTheme.typography.labelSmall,
                            color = Primary.copy(0.8f),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
                // Big week number
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = "$elapsedWeeks",
                        style = MaterialTheme.typography.displayLarge.copy(fontSize = 52.sp),
                        color = Primary,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text  = "أسبوع",
                        style = MaterialTheme.typography.labelSmall.copy(letterSpacing = 0.5.sp),
                        color = Primary.copy(0.6f)
                    )
                }
            }
        }
    }
}

// ── Today's Workout ───────────────────────────────────────────────────────────
@Composable
fun TodaysWorkoutCard(planName: String, exerciseCount: Int, onStart: () -> Unit) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onStart() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text  = "تمرين اليوم",
                    color = OnSurfaceVariant,
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text       = planName,
                    style      = MaterialTheme.typography.headlineMedium,
                    color      = OnSurface,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text  = "$exerciseCount تمارين • اضغط للبدء",
                    style = MaterialTheme.typography.bodyMedium,
                    color = OnSurfaceVariant
                )
            }
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = "ابدأ التمرين",
                    tint     = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

// ── Energy Card ───────────────────────────────────────────────────────────────
@Composable
private fun EnergyHomeCard(consumed: Int, target: Int) {
    val progress  = (consumed.toFloat() / target.toFloat().coerceAtLeast(1f)).coerceIn(0f, 1f)
    val remaining = target - consumed
    val animProg by animateFloatAsState(
        targetValue   = progress,
        animationSpec = tween(900, easing = EaseOutCubic),
        label         = "calProg"
    )
    val overBudget = remaining < 0

    GlassCard(modifier = Modifier.fillMaxWidth(), accentGlow = true) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment     = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text  = "السعرات اليوم",
                        color = OnSurfaceVariant,
                        style = MaterialTheme.typography.labelSmall.copy(letterSpacing = 0.5.sp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = consumed.toString(),
                        style = MaterialTheme.typography.displayLarge.copy(
                            brush = Brush.horizontalGradient(
                                listOf(if (overBudget) Color(0xFFFF6B6B) else Primary,
                                       if (overBudget) Color(0xFFFF9898) else Primary.copy(0.7f))
                            ),
                            fontSize = 48.sp
                        ),
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text  = "من $target kcal",
                        style = MaterialTheme.typography.bodySmall,
                        color = OnSurfaceVariant
                    )
                    Spacer(Modifier.height(10.dp))
                    // Slim progress bar
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Color.White.copy(0.07f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(animProg)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(2.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            if (overBudget) Color(0xFFFF6B6B) else Primary,
                                            if (overBudget) Color(0xFFFFB347) else Primary.copy(0.6f)
                                        )
                                    )
                                )
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text  = if (!overBudget) "متبقي $remaining kcal" else "زيادة ${-remaining} kcal ⚠",
                        style = MaterialTheme.typography.labelSmall,
                        color = if (!overBudget) Primary.copy(0.8f) else Color(0xFFFF6B6B)
                    )
                }
                // Circular progress
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(76.dp)) {
                    CircularProgressIndicator(
                        progress    = { 1f },
                        modifier    = Modifier.size(76.dp),
                        color       = Color.White.copy(0.05f),
                        strokeWidth = 6.dp
                    )
                    CircularProgressIndicator(
                        progress    = { animProg },
                        modifier    = Modifier.size(76.dp),
                        color       = if (!overBudget) Primary else Color(0xFFFF6B6B),
                        strokeWidth = 6.dp
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text  = "${(progress * 100).toInt()}%",
                            style = MaterialTheme.typography.labelMedium,
                            color = OnSurface,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

// ── Macro Card ────────────────────────────────────────────────────────────────
@Composable
private fun MacroHomeCard(label: String, consumed: Int, target: Int, unit: String, modifier: Modifier = Modifier) {
    val progress = (consumed.toFloat() / target.toFloat().coerceAtLeast(1f)).coerceIn(0f, 1f)
    val animProg by animateFloatAsState(targetValue = progress, animationSpec = tween(800, easing = EaseOutCubic), label = "macroProg")

    GlassCard(modifier = modifier, padding = 14.dp) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier            = Modifier.fillMaxWidth()
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(52.dp)) {
                CircularProgressIndicator(
                    progress    = { 1f },
                    modifier    = Modifier.size(52.dp),
                    color       = Color.White.copy(0.05f),
                    strokeWidth = 4.5.dp
                )
                CircularProgressIndicator(
                    progress    = { animProg },
                    modifier    = Modifier.size(52.dp),
                    color       = Primary,
                    strokeWidth = 4.5.dp
                )
                Text(
                    text       = "${consumed}",
                    style      = MaterialTheme.typography.labelSmall,
                    color      = OnSurface,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(label, style = MaterialTheme.typography.labelSmall.copy(letterSpacing = 0.3.sp),
                color = OnSurface, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
            Text("/ $target$unit", style = MaterialTheme.typography.bodySmall, color = OnSurfaceVariant, textAlign = TextAlign.Center)
        }
    }
}

// ── Subscription Card ─────────────────────────────────────────────────────────
@Composable
fun SubscriptionReminderCard(viewModel: KineticViewModel) {
    val daysLeft = viewModel.getSubscriptionDaysLeft()
    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text  = "اشتراك الجيم",
                    color = OnSurfaceVariant,
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text       = "$daysLeft يوم متبقي",
                    style      = MaterialTheme.typography.headlineMedium,
                    color      = if (daysLeft <= 7L) MaterialTheme.colorScheme.error else OnSurface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text  = "عدّل من صفحة الخطة",
                    style = MaterialTheme.typography.bodyMedium,
                    color = OnSurfaceVariant
                )
            }
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        if (daysLeft <= 7L) MaterialTheme.colorScheme.error.copy(alpha = 0.15f)
                        else SurfaceContainerHigh
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector        = if (daysLeft <= 7L) Icons.Default.Warning else Icons.Default.DateRange,
                    contentDescription = null,
                    tint               = if (daysLeft <= 7L) MaterialTheme.colorScheme.error else Primary
                )
            }
        }
    }
}

// ── Weekly Calendar Card ───────────────────────────────────────────────────────

@Composable
fun WeeklyCalendarCard(recentSessions: List<com.example.data.WorkoutSession>) {
    val cal       = java.util.Calendar.getInstance()
    val today     = cal.get(java.util.Calendar.DAY_OF_WEEK)
    val dayLabels = listOf("الأحد","الاثنين","الثلاثاء","الأربعاء","الخميس","الجمعة","السبت")

    // Build set of day-of-week indices that had sessions this week
    val weekStart = java.util.Calendar.getInstance().apply {
        set(java.util.Calendar.DAY_OF_WEEK, firstDayOfWeek)
        set(java.util.Calendar.HOUR_OF_DAY, 0); set(java.util.Calendar.MINUTE, 0)
        set(java.util.Calendar.SECOND, 0); set(java.util.Calendar.MILLISECOND, 0)
    }.timeInMillis
    val workedDays = recentSessions
        .filter { it.completedAt >= weekStart }
        .map {
            val c = java.util.Calendar.getInstance()
            c.timeInMillis = it.completedAt
            c.get(java.util.Calendar.DAY_OF_WEEK)
        }.toSet()

    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.DateRange, null, tint = Primary, modifier = Modifier.size(14.dp))
                    Text("هذا الأسبوع", style = MaterialTheme.typography.labelSmall, color = Primary)
                    Spacer(Modifier.weight(1f))
                    Text("${workedDays.size}/7 أيام هذا الأسبوع", style = MaterialTheme.typography.labelSmall, color = OnSurfaceVariant)
                }
            }
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                for (dayIdx in 1..7) {
                    val isToday   = dayIdx == today
                    val didTrain  = dayIdx in workedDays
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)) {
                        Text(dayLabels[dayIdx - 1].take(3),
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isToday) Primary else OnSurfaceVariant.copy(.6f),
                            maxLines = 1)
                        Spacer(Modifier.height(5.dp))
                        Box(
                            modifier = Modifier.size(30.dp).clip(androidx.compose.foundation.shape.CircleShape)
                                .background(when { didTrain -> Primary; isToday -> Primary.copy(.2f); else -> SurfaceContainerHigh })
                                .then(if (isToday && !didTrain) Modifier.border(1.5.dp, Primary, androidx.compose.foundation.shape.CircleShape) else Modifier),
                            contentAlignment = Alignment.Center
                        ) {
                            if (didTrain) Icon(Icons.Default.Check, null, tint = Color.Black, modifier = Modifier.size(14.dp))
                        }
                    }
                }
            }
        }
    }
}

// ── App Guide Card ────────────────────────────────────────────────────────────

@Composable
fun AppGuideCard() {
    var expanded by remember { mutableStateOf(false) }

    val sections = listOf(
        Triple("🏠", "الرئيسية", "لقطة كاملة على يومك: السعرات والماكرو اللي أكلته، تمرين اليوم، وتقدم الأسبوع. كل ما تخلص تمرين كامل يتسجل تلقائي وتقدر تشوف كم يوم اتمرنت الأسبوع ده."),
        Triple("💪", "التمارين", "افتح التمرين المطلوب وابدأ. اضغط على اسم التمرين للتفاصيل والنصائح. لما تخلص مجموعة اضغط ✓ — الرست تايمر بيبدأ وبيصحّيك لما ينتهي. عدّل الوزن والعدات في كل مجموعة."),
        Triple("📅", "الخطة", "اضبط هدفك (تضخيم/تنشيف/ثبات)، مدة الخطة بالأسابيع، وتاريخ اشتراك الجيم. اضغط \"ضبط الخطة\" في الأعلى لتعديل أي شيء."),
        Triple("📊", "التقدم", "شوف منحنى قوتك في أي تمرين اخترته. سجّل وزن جسمك يومياً من زر + في الأعلى. اضغط \"القياسات\" لتتبع مقاسات جسمك (صدر، خصر، أرجل)."),
        Triple("🥗", "التغذية", "ابحث عن أي أكل بالعربي أو الإنجليزي وسجّله. اضبط سعراتك ومعادلتك من أيقونة الحاسبة. \"وجباتي المفضلة\" بتحفظ وجباتك المكررة بكل مكوناتها وأوزانها."),
        Triple("🧪", "المكملات", "دليل علمي لكل مكمل: هل يستاهل فعلاً، الجرعة الصح، التوقيت المناسب، وأفضل منتجات متاحة في السوق المصري."),
        Triple("🏃", "الكارديو", "اختار نوع الكارديو وابدأ التايمر بالزر ▶. بيتحسب وقت الجلسة تلقائي. اضغط ⓘ لتفاصيل كل نوع وأثره على الركبة والمفاصل.")
    )

    GlassCard(modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded }) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier.size(32.dp).clip(RoundedCornerShape(8.dp))
                                .background(Primary.copy(0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("⚡", style = MaterialTheme.typography.bodyMedium)
                        }
                        Column {
                            Text("دليل التطبيق السريع",
                                style = MaterialTheme.typography.bodyLarge,
                                color = OnSurface,
                                fontWeight = FontWeight.Bold)
                            Text("اضغط لمعرفة كل قسم",
                                style = MaterialTheme.typography.labelSmall,
                                color = OnSurfaceVariant)
                        }
                    }
                    Icon(
                        if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        null, tint = OnSurfaceVariant, modifier = Modifier.size(20.dp)
                    )
                }

                if (expanded) {
                    Spacer(Modifier.height(14.dp))
                    HorizontalDivider(color = Color.White.copy(0.07f))
                    Spacer(Modifier.height(12.dp))
                    sections.forEachIndexed { i, (emoji, title, desc) ->
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Box(
                                modifier = Modifier.size(36.dp).clip(RoundedCornerShape(10.dp))
                                    .background(SurfaceContainerHigh),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(emoji, style = MaterialTheme.typography.bodyMedium)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(title,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Primary,
                                    fontWeight = FontWeight.Bold)
                                Spacer(Modifier.height(2.dp))
                                Text(desc,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = OnSurfaceVariant)
                            }
                        }
                        if (i < sections.lastIndex) {
                            HorizontalDivider(
                                color = Color.White.copy(0.04f),
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
