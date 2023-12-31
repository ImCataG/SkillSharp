package com.ciupercutzaroz.skillsharp

import com.google.gson.Gson


// create a class or multiple classes if needed for the following json:
/*
[
{
    "categoryName": "Coding",
    "categoryRoadmaps": [
    {
        "roadmapName": "Python",
        "roadmapDifficulties": [
        {
            "difficultyLevel": "EASY",
            "difficultySkills": [
            {
                "skillTitle": "Basic syntax",
                "skillDescription": "Learn basic stuff about python",
                "skillStatus": false,
                "skillResources": [
                {
                    "resourceName": "Python book for noobs",
                    "resourceDescription ": "Book that goes through basic syntax in Python"
                }
                ]
            }
            ]
        }
        ]
    }
    ]
}
]
*/

class Category(
    val categoryName: String,
    val categoryRoadmaps: List<Roadmap>
)

class Roadmap(
    val roadmapName: String,
    val roadmapDifficulties: List<Difficulty>
)

class Difficulty(
    val difficultyLevel: String,
    val difficultySkills: List<Skill>
)

class Skill(
    val skillTitle: String,
    val skillDescription: String,
    var skillStatus: Boolean,
    val skillResources: List<Resource>
)

class Resource(
    val resourceName: String,
    val resourceDescription: String
)

fun DeserializeCategoryList(json: String): List<Category> {
    val gson = Gson()
    return gson.fromJson(json, Array<Category>::class.java).toList()
}

fun DeserializeCategory(json: String): Category {
    val gson = Gson()
    return gson.fromJson(json, Category::class.java)
}

fun SerializeCategoryList(categories: List<Category>): String {
    val gson = Gson()
    return gson.toJson(categories)
}

fun SerializeCategory(category: Category): String {
    val gson = Gson()
    return gson.toJson(category)
}

fun SerializeRoadmapList(roadmaps: List<Roadmap>): String {
    val gson = Gson()
    return gson.toJson(roadmaps)
}

fun DeserializeRoadmapList(json: String): List<Roadmap> {
    val gson = Gson()
    return gson.fromJson(json, Array<Roadmap>::class.java).toList()
}