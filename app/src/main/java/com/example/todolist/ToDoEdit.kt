package com.example.todolist

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

val MIN_TITLE_LENGTH = 3
val MAX_TITLE_LENGTH = 20
val MAX_DESCRIPTION_LENGTH = 255

private val validationViolations = mutableStateListOf<String>()
@Composable
fun ToDoEdit(toDoItem: ToDoItem, navController: NavController, saveFunction: (ToDoItem) -> Unit) {
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            for (violation in validationViolations) {
                Text(violation, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Red),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
            Text("Title:")
            TextField(toDoItem.title.value, { value -> toDoItem.title.value = value })
            Text("Description:")
            TextField(toDoItem.description.value, { value -> toDoItem.description.value = value })
            Button(onClick = {
                validationCheck(toDoItem)
                if (validationViolations.isEmpty()) {
                    saveFunction(toDoItem)
                    navController.popBackStack()
                }
            }) {
                Text("Save")
            }
        }
    }
}

fun validationCheck(toDoItem: ToDoItem) {
    validationViolations.clear()

    if (toDoItem.title.value.length < MIN_TITLE_LENGTH) {
        validationViolations.add("Title must be at least 3 symbols long")
    }
    if (MAX_TITLE_LENGTH < toDoItem.title.value.length) {
        validationViolations.add("Title must be at most 20 symbols long")
    }
    if (MAX_DESCRIPTION_LENGTH < toDoItem.description.value.length) {
        validationViolations.add("Description must be at most 255 symbols long")
    }
}