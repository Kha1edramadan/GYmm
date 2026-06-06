package com.example.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.ui.screens.*
import com.example.ui.theme.*

sealed class Screen(val route: String, val titleAr: String, val icon: ImageVector) {
    object Splash    : Screen("splash",    "Splash",   Icons.Filled.Dashboard)
    object Home      : Screen("home",      "الرئيسية", Icons.Filled.Home)
    object Workout   : Screen("workout",   "تمارين",   Icons.Filled.FitnessCenter)
    object Plan      : Screen("plan",      "الخطة",    Icons.Filled.EventNote)
    object Progress  : Screen("progress",  "التقدم",   Icons.Filled.Insights)
    object Nutrition : Screen("nutrition", "تغذية",    Icons.Filled.Restaurant)
}

private val bottomNavItems = listOf(
    Screen.Home, Screen.Workout, Screen.Plan, Screen.Progress, Screen.Nutrition
)

@Composable
fun KineticAppMain() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDest      = navBackStackEntry?.destination
    val hideBottomBar    = currentDest?.route == Screen.Splash.route

    Scaffold(
        containerColor = Surface,
        bottomBar = {
            if (!hideBottomBar) {
                KineticNavBar(
                    items       = bottomNavItems,
                    currentDest = currentDest,
                    onNavigate  = { screen ->
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState    = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController    = navController,
            startDestination = Screen.Splash.route,
            modifier         = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            }
            composable(Screen.Home.route) {
                HomeScreen(onStartWorkout = { planId -> navController.navigate("workout_session/$planId") })
            }
            composable(Screen.Workout.route) {
                WorkoutScreen(onPlanClicked = { planId ->
                    if (planId == "cardio") navController.navigate("cardio_screen")
                    else                    navController.navigate("workout_session/$planId")
                })
            }
            composable("cardio_screen") { CardioScreen() }
            composable("workout_session/{planId}") { back ->
                val planId = back.arguments?.getString("planId") ?: return@composable
                WorkoutSessionScreen(
                    planId   = planId,
                    onFinish = { sessionId, planName ->
                        navController.navigate("workout_complete/$sessionId/${planName.replace("/", "-")}") {
                            popUpTo(Screen.Home.route)
                        }
                    }
                )
            }
            composable("workout_complete/{sessionId}/{planName}") { back ->
                val sessionId = back.arguments?.getString("sessionId")?.toLongOrNull() ?: 0L
                val planName  = back.arguments?.getString("planName") ?: ""
                WorkoutCompletionScreen(
                    sessionId = sessionId,
                    planName  = planName,
                    onDone    = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Home.route) { inclusive = true } } }
                )
            }
            composable(Screen.Plan.route)      { PlanScreen() }
            composable(Screen.Progress.route)  {
                ProgressScreen(
                    onNavigateToMeasurements = { navController.navigate("body_measurements") }
                )
            }
            composable("body_measurements")    { BodyMeasurementsScreen(onBack = { navController.popBackStack() }) }
            composable(Screen.Nutrition.route) {
                NutritionScreen(
                    onNutrientsClick   = { navController.navigate("micronutrients") },
                    onCalculatorClick  = { navController.navigate("calorie_calculator") },
                    onSupplementsClick = { navController.navigate("supplements") }
                )
            }
            composable("micronutrients")       { NutrientSourcesScreen { navController.popBackStack() } }
            composable("calorie_calculator")   { CalorieCalculatorScreen(onBack = { navController.popBackStack() }) }
            composable("supplements")          { SupplementsScreen { navController.popBackStack() } }
        }
    }
}

// ── Creative Floating Nav Bar ──────────────────────────────────────────────────
@Composable
private fun KineticNavBar(
    items: List<Screen>,
    currentDest: androidx.navigation.NavDestination?,
    onNavigate: (Screen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        // Outer pill container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFF161818))
                .drawBehind {
                    // Subtle top edge highlight
                    drawLine(
                        brush  = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White.copy(0.12f),
                                Color.White.copy(0.06f),
                                Color.Transparent
                            )
                        ),
                        start       = Offset(0f, 1f),
                        end         = Offset(size.width, 1f),
                        strokeWidth = 1.2f
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment     = Alignment.CenterVertically
            ) {
                items.forEach { screen ->
                    val selected = currentDest?.hierarchy?.any { it.route == screen.route } == true
                    NavItem(screen = screen, selected = selected, onClick = { onNavigate(screen) })
                }
            }
        }
    }
}

@Composable
private fun NavItem(screen: Screen, selected: Boolean, onClick: () -> Unit) {
    val iconColor by animateColorAsState(
        targetValue = if (selected) Color.Black else Color(0xFF6B6B6B),
        animationSpec = tween(250),
        label = "iconColor"
    )
    val indicatorAlpha by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium),
        label = "alpha"
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                indication          = null,
                interactionSource   = remember { MutableInteractionSource() },
                onClick             = onClick
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        // Lime pill behind selected icon
        Box(
            modifier = Modifier
                .width(48.dp)
                .height(36.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Primary.copy(alpha = indicatorAlpha)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector  = screen.icon,
                contentDescription = screen.titleAr,
                tint         = iconColor,
                modifier     = Modifier.size(20.dp)
            )
        }

        // Label visible only when selected (slide up effect)
        if (!selected) {
            // Just the icon, no label — cleaner look
        }
    }
}
