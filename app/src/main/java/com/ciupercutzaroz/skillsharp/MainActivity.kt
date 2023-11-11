package com.ciupercutzaroz.skillsharp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ciupercutzaroz.skillsharp.ui.theme.SkillSharpTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillSharpTheme {
                Surface(color = MaterialTheme.colorScheme.background) {LaunchApp()}
            }
        }
    }
}

@Composable
fun LaunchApp() {
    val navController = rememberNavController()
    var SkillName = "SkillName"
    NavHost(navController = navController, startDestination = "main") {
    composable(
        route = "main",
        enterTransition = {
            slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(700)
            )
        }) { MainScreen(navController) }
    composable(
        route = "SkillPage",
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }) { SkillPage(SkillName) }
    }
}

// Create a main screen with a title and a list of items
@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SkillSharp",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        )
        LazyColumn {
            items(listOf("Item 1", "Item 2", "Item 3")) { item ->
                Log.d("MainScreen", "Item: $item")
                Button(onClick = { navController.navigate("SkillPage") }) {
                    Text(text = item)
                }
            }
        }
    }
}
@Composable
fun SkillPage(SkillName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = SkillName,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        )
    }
}