package com.ciupercutzaroz.skillsharp

import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
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
    val category2 = DeserializeCategory("  {\n" +
            "    \"categoryName\": \"Data Analysis\",\n" +
            "    \"categoryRoadmaps\": [\n" +
            "      {\n" +
            "        \"roadmapName\": \"Microsoft Excel\",\n" +
            "        \"roadmapDifficulties\": [\n" +
            "          {\n" +
            "            \"difficultyLevel\": \"EASY\",\n" +
            "            \"difficultySkills\": [\n" +
            "              {\n" +
            "                \"skillTitle\": \"Basic Functions and Formulas\",\n" +
            "                \"skillDescription\": \"Understand fundamental Excel functions like SUM, AVERAGE, and creating basic formulas.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel Easy\",\n" +
            "                    \"resourceDescription\": \"Website offering beginner tutorials on basic functions and formulas.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel 2019 Bible by Michael Alexander, Dick Kusleika\",\n" +
            "                    \"resourceDescription\": \"Comprehensive book covering all basic features of Excel.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"Data Entry and Formatting\",\n" +
            "                \"skillDescription\": \"Learn how to input and format data effectively in Excel.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"GCFLearnFree.org\",\n" +
            "                    \"resourceDescription\": \"Free tutorials on data entry and formatting in Excel.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"YouTube: Excel Basics\",\n" +
            "                    \"resourceDescription\": \"Video tutorials covering data entry and cell formatting.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"Basic Charts and Graphs\",\n" +
            "                \"skillDescription\": \"Create and customize basic charts and graphs in Excel.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"ExcelJet\",\n" +
            "                    \"resourceDescription\": \"Easy-to-follow guides for creating basic charts and graphs.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"YouTube: ExcelIsFun\",\n" +
            "                    \"resourceDescription\": \"Step-by-step video tutorials on Excel charts and graphs.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"difficultyLevel\": \"MEDIUM\",\n" +
            "            \"difficultySkills\": [\n" +
            "              {\n" +
            "                \"skillTitle\": \"Advanced Formulas\",\n" +
            "                \"skillDescription\": \"Master complex formulas like VLOOKUP, INDEX, and MATCH.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel Jet\",\n" +
            "                    \"resourceDescription\": \"Guides and examples for advanced Excel formulas.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel 2019 Power Programming with VBA by Michael Alexander, Dick Kusleika\",\n" +
            "                    \"resourceDescription\": \"Book covering advanced formulas and automation with VBA.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"PivotTables\",\n" +
            "                \"skillDescription\": \"Learn to create, analyze, and visualize data with PivotTables.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Chandoo.org\",\n" +
            "                    \"resourceDescription\": \"Comprehensive tutorials on PivotTables.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"YouTube: Leila Gharani\",\n" +
            "                    \"resourceDescription\": \"In-depth PivotTable tutorials and tips.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"Data Analysis and Reporting\",\n" +
            "                \"skillDescription\": \"Develop skills in data analysis, using tools like Data Analysis Toolpak.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Coursera: Excel Skills for Data Analysis and Visualization\",\n" +
            "                    \"resourceDescription\": \"Online course covering data analysis techniques in Excel.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Udemy: Excel Analytics\",\n" +
            "                    \"resourceDescription\": \"Course focusing on analytical tools in Excel for business decision-making.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"difficultyLevel\": \"HARD\",\n" +
            "            \"difficultySkills\": [\n" +
            "              {\n" +
            "                \"skillTitle\": \"Macros and VBA Programming\",\n" +
            "                \"skillDescription\": \"Automate tasks and create custom Excel solutions using VBA.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel VBA Programming For Dummies by Michael Alexander\",\n" +
            "                    \"resourceDescription\": \"Book introducing VBA programming in Excel.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Udemy: Mastering Excel VBA\",\n" +
            "                    \"resourceDescription\": \"Comprehensive course on VBA for Excel.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"Complex Data Visualization\",\n" +
            "                \"skillDescription\": \"Create complex and dynamic data visualizations in Excel.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"YouTube: Excel Campus\",\n" +
            "                    \"resourceDescription\": \"Tutorials on advanced data visualization techniques.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Excel Charts by John Walkenbach\",\n" +
            "                    \"resourceDescription\": \"Detailed guide to creating advanced charts in Excel.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"skillTitle\": \"Integration with Other Tools\",\n" +
            "                \"skillDescription\": \"Learn to integrate Excel with SQL, Power BI, and other data tools.\",\n" +
            "                \"skillStatus\": false,\n" +
            "                \"skillResources\": [\n" +
            "                  {\n" +
            "                    \"resourceName\": \"LinkedIn Learning: Integrating Excel with Other Office Applications\",\n" +
            "                    \"resourceDescription\": \"Course on using Excel with other Microsoft Office tools.\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"resourceName\": \"Power Query for Power BI and Excel by Chris Webb\",\n" +
            "                    \"resourceDescription\": \"Book on integrating Excel with Power BI and Power Query.\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }")

    val CategoryList = DeserializeCategoryList("[{\n" +
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
            "},\n" +
            "    {\n" +
            "        \"categoryName\": \"Data Analysis\",\n" +
            "        \"categoryRoadmaps\": [\n" +
            "            {\n" +
            "                \"roadmapName\": \"Microsoft Excel\",\n" +
            "                \"roadmapDifficulties\": [\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"EASY\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Basic Functions and Formulas\",\n" +
            "                                \"skillDescription\": \"Understand fundamental Excel functions like SUM, AVERAGE, and creating basic formulas.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel Easy\",\n" +
            "                                        \"resourceDescription\": \"Website offering beginner tutorials on basic functions and formulas.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel 2019 Bible by Michael Alexander, Dick Kusleika\",\n" +
            "                                        \"resourceDescription\": \"Comprehensive book covering all basic features of Excel.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Data Entry and Formatting\",\n" +
            "                                \"skillDescription\": \"Learn how to input and format data effectively in Excel.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"GCFLearnFree.org\",\n" +
            "                                        \"resourceDescription\": \"Free tutorials on data entry and formatting in Excel.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"YouTube: Excel Basics\",\n" +
            "                                        \"resourceDescription\": \"Video tutorials covering data entry and cell formatting.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Basic Charts and Graphs\",\n" +
            "                                \"skillDescription\": \"Create and customize basic charts and graphs in Excel.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"ExcelJet\",\n" +
            "                                        \"resourceDescription\": \"Easy-to-follow guides for creating basic charts and graphs.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"YouTube: ExcelIsFun\",\n" +
            "                                        \"resourceDescription\": \"Step-by-step video tutorials on Excel charts and graphs.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"MEDIUM\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Advanced Formulas\",\n" +
            "                                \"skillDescription\": \"Master complex formulas like VLOOKUP, INDEX, and MATCH.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel Jet\",\n" +
            "                                        \"resourceDescription\": \"Guides and examples for advanced Excel formulas.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel 2019 Power Programming with VBA by Michael Alexander, Dick Kusleika\",\n" +
            "                                        \"resourceDescription\": \"Book covering advanced formulas and automation with VBA.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"PivotTables\",\n" +
            "                                \"skillDescription\": \"Learn to create, analyze, and visualize data with PivotTables.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Chandoo.org\",\n" +
            "                                        \"resourceDescription\": \"Comprehensive tutorials on PivotTables.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"YouTube: Leila Gharani\",\n" +
            "                                        \"resourceDescription\": \"In-depth PivotTable tutorials and tips.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Data Analysis and Reporting\",\n" +
            "                                \"skillDescription\": \"Develop skills in data analysis, using tools like Data Analysis Toolpak.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Coursera: Excel Skills for Data Analysis and Visualization\",\n" +
            "                                        \"resourceDescription\": \"Online course covering data analysis techniques in Excel.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Udemy: Excel Analytics\",\n" +
            "                                        \"resourceDescription\": \"Course focusing on analytical tools in Excel for business decision-making.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"HARD\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Macros and VBA Programming\",\n" +
            "                                \"skillDescription\": \"Automate tasks and create custom Excel solutions using VBA.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel VBA Programming For Dummies by Michael Alexander\",\n" +
            "                                        \"resourceDescription\": \"Book introducing VBA programming in Excel.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Udemy: Mastering Excel VBA\",\n" +
            "                                        \"resourceDescription\": \"Comprehensive course on VBA for Excel.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Complex Data Visualization\",\n" +
            "                                \"skillDescription\": \"Create complex and dynamic data visualizations in Excel.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"YouTube: Excel Campus\",\n" +
            "                                        \"resourceDescription\": \"Tutorials on advanced data visualization techniques.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Excel Charts by John Walkenbach\",\n" +
            "                                        \"resourceDescription\": \"Detailed guide to creating advanced charts in Excel.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Integration with Other Tools\",\n" +
            "                                \"skillDescription\": \"Learn to integrate Excel with SQL, Power BI, and other data tools.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"LinkedIn Learning: Integrating Excel with Other Office Applications\",\n" +
            "                                        \"resourceDescription\": \"Course on using Excel with other Microsoft Office tools.\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Power Query for Power BI and Excel by Chris Webb\",\n" +
            "                                        \"resourceDescription\": \"Book on integrating Excel with Power BI and Power Query.\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"categoryName\": \"Software Development\",\n" +
            "        \"categoryRoadmaps\": [\n" +
            "            {\n" +
            "                \"roadmapName\": \"Object Oriented Programming (OOP)\",\n" +
            "                \"roadmapDifficulties\": [\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"EASY\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Understanding OOP Concepts\",\n" +
            "                                \"skillDescription\": \"Grasp the basics of OOP: classes, objects, inheritance, and encapsulation.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Head First Object-Oriented Analysis and Design\",\n" +
            "                                        \"resourceDescription\": \"Book introducing OOP concepts in an engaging manner\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Object-Oriented Programming in 7 minutes | Mosh\",\n" +
            "                                        \"resourceDescription\": \"YouTube video providing a quick overview of OOP\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Implementing Basic Classes and Objects\",\n" +
            "                                \"skillDescription\": \"Learn to create and use basic classes and objects in a programming language.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"GeeksforGeeks: Classes and Objects in Java\",\n" +
            "                                        \"resourceDescription\": \"Article detailing how to implement classes and objects in Java\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Object-oriented Programming in Python | Codecademy\",\n" +
            "                                        \"resourceDescription\": \"Interactive course on implementing OOP in Python\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"MEDIUM\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Inheritance and Polymorphism\",\n" +
            "                                \"skillDescription\": \"Understand and apply inheritance and polymorphism in OOP.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Java Programming Masterclass for Software Developers | Udemy\",\n" +
            "                                        \"resourceDescription\": \"Course covering OOP concepts like inheritance and polymorphism in Java\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Effective Java by Joshua Bloch\",\n" +
            "                                        \"resourceDescription\": \"Book with best practices in Java, including inheritance\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Design Patterns\",\n" +
            "                                \"skillDescription\": \"Learn about common OOP design patterns like Singleton, Factory, and Observer.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Head First Design Patterns\",\n" +
            "                                        \"resourceDescription\": \"Book that introduces design patterns in a reader-friendly way\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Design Patterns on refactoring.guru\",\n" +
            "                                        \"resourceDescription\": \"Website with comprehensive information on design patterns\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"difficultyLevel\": \"HARD\",\n" +
            "                        \"difficultySkills\": [\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Advanced OOP Concepts\",\n" +
            "                                \"skillDescription\": \"Dive into advanced topics like composition over inheritance and SOLID principles.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Clean Architecture by Robert C. Martin\",\n" +
            "                                        \"resourceDescription\": \"Book discussing advanced OOP topics and clean architecture\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"SOLID Principles: Introducing Software Architecture & Design | Pluralsight\",\n" +
            "                                        \"resourceDescription\": \"Online course explaining SOLID principles in depth\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"skillTitle\": \"Real-world OOP Application\",\n" +
            "                                \"skillDescription\": \"Apply OOP concepts in building complex, real-world applications.\",\n" +
            "                                \"skillStatus\": false,\n" +
            "                                \"skillResources\": [\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Building Software Systems At Google and Lessons Learned by Titus Winters\",\n" +
            "                                        \"resourceDescription\": \"Talk on YouTube discussing OOP in large-scale systems at Google\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"resourceName\": \"Refactoring: Improving the Design of Existing Code by Martin Fowler\",\n" +
            "                                        \"resourceDescription\": \"Book focused on refactoring code with a focus on OOP\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "]")




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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add Skill",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Horizontal scrollable row for buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            categoryList.forEach { category ->
                Button(
                    onClick = {
                        // Handle button click
                        Log.d("AddSkillPage", "Selected Category: ${category.categoryName}")
                    },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(category.categoryName)
                }
            }
        }
    }
}
