package com.example.todolist.ui.theme

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.todolist.ToDoItem


@Composable
fun ToDoCompose(toDoItem: ToDoItem, ID: Int, navController: NavController) {
    Divider()
    Box (Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate("ToDoDetails/$ID")
        }
    ) {
        Checkbox(
            toDoItem.isDone,
            { toDoItem.toggleDone() },
            Modifier.align(Alignment.CenterStart)
        )
        Text(
            toDoItem.getTitle(),
            Modifier.align(Alignment.Center)
        )
        Icon(
            Icons.Rounded.KeyboardArrowRight,
            "Arrow to view todo",
            Modifier.align(Alignment.CenterEnd)
        )
    }
}