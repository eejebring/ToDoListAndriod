package com.example.todolist.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ToDoItem

@Composable
fun ToDoCompose(item: ToDoItem) {
    val toDo = remember { mutableStateOf(ToDoItem("the other thing")) }
    var num = remember { mutableStateOf(0) }
    Divider()
    Box (Modifier
        .fillMaxWidth()
        .clickable { num.value++ }
    ) {
        Checkbox(
            toDo.value.isDone,
            { toDo.value.toggleDone() },
            Modifier.align(Alignment.CenterStart)
        )
        Text(toDo.value.getTitle() + num.value,
            Modifier.align(Alignment.Center)
        )
        Icon(
            Icons.Rounded.KeyboardArrowRight,
            "Arrow to view todo",
            Modifier.align(Alignment.CenterEnd)
        )
    }
}