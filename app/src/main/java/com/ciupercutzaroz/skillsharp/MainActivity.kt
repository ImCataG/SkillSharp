package com.ciupercutzaroz.skillsharp

import android.os.Bundle
import android.util.Log
import android.widget.Spinner
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

class SkillsViewModel : ViewModel() {
    val category1 = DeserializeCategory("{\n" +
            "    \"categoryName\": \"Coding\",\n" +
            "    \"categoryRoadmaps\": [\n" +
            "    {\n" +
            "        \"roadmapName\": \"Python\",\n" +
            "        \"roadmapDifficulties\": [\n" +
            "        {\n" +
            "            \"difficultyLevel\": \"EASY\",\n" +
            "            \"difficultySkills\": [\n" +
            "            {\n" +
            "                \"skillTitle\": \"Basic syntax\",\n" +
            "                \"skillDescription\": \"Learn basic stuff about python\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                {\n" +
            "                    \"resourceName\": \"Python book for noobs\",\n" +
            "                    \"resourceDescription \": \"Book that goes through basic syntax in Python\"\n" +
            "                }\n" +
            "                ]\n" +
            "            }\n" +
            "            ]\n" +
            "        }\n" +
            "        ]\n" +
            "    }\n" +
            "    ]\n" +
            "}")

    val CategoryList = listOf(category1)


}
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
        route = "SkillPage/{skillName}",
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
        }) { backStackEntry ->
        val skillName = backStackEntry.arguments?.getString("skillName") ?: "Default Skill"
        SkillPage(skillName)
        }
    composable(
        route = "AddSkillPage",
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
        }) {
        AddSkillPage()
        }
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
                Button(onClick = { navController.navigate("SkillPage/$item") }) {
                    Text(text = item)
                    }
                }
            }
        Button(onClick = { navController.navigate("AddSkillPage") }) {
            Text(text = "Add Item")
            }

        }
}
@Composable
fun SkillPage(skillName: String, viewModel: SkillsViewModel = viewModel()) {
//    val skill = viewModel.getSkillByName(skillName) ?: return

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("placeholder", fontSize = 24.sp)
    }
}

@Composable
fun AddSkillPage(viewModel: SkillsViewModel = viewModel()) {
    val categoryList = viewModel.CategoryList
    var expanded by remember { mutableStateOf(false) } // Use 'by remember' to properly handle state

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Add Skill",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
            )
            Box(){
                Log.d("BoxAtLeast", "Aye we here")
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    Log.d("AddSkillPage", "Aye at least we here")
                    categoryList.forEach { category ->
                        Log.d("AddSkillPage", "Category: ${category.categoryName}")
                        DropdownMenuItem(
                            text = { Text(category.categoryName) },
                            onClick = {
                                // Handle item selection
                                expanded = false
                            },
                            leadingIcon = {
                                // Optional leading icon
                            }
                        )
                    }
                }
            }
        }
    }
}