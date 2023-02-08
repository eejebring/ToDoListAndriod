package com.example.todolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun ToDoCompose(toDoID: Int, navController: NavController) {
    Divider()
    Box (Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate("ToDoDetails/$toDoID")
        }
    ) {
        Checkbox(
            listOfToDos[toDoID].isDone.value,
            { listOfToDos[toDoID].toggleDone() },
            Modifier.align(Alignment.CenterStart)
        )
        Text(
            listOfToDos[toDoID].title.value,
            Modifier.align(Alignment.Center)
        )
        Icon(
            Icons.Rounded.KeyboardArrowRight,
            "Arrow to view todo",
            Modifier.align(Alignment.CenterEnd)
        )
    }
}