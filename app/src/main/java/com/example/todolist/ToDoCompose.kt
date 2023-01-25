package com.example.todolist.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.todolist.ToDoItem

@Composable
fun ToDoCompose(item: ToDoItem) {
    Box (Modifier.fillMaxWidth()) {
        Checkbox(
            item.isDone,
            { item.toggleDone() },
            Modifier.align(Alignment.CenterStart)
        )
        Text(item.getTitle(),
            Modifier.align(Alignment.Center)
        )
        Icon(
            Icons.Rounded.KeyboardArrowRight,
            "Arrow to view todo",
            Modifier.align(Alignment.CenterEnd)
        )
    }
}