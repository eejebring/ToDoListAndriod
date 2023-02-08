package com.example.todolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Heading(text: String) {
    Text(text = text,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun CheckboxWithText (toDoItem: ToDoItem) {
    Row (verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            toDoItem.isDone.value,
            { toDoItem.toggleDone() }
            //Modifier.align(Alignment.CenterStart)
        )
        if (toDoItem.isDone.value) {
            Text("Complete", color = Color.Green, modifier = Modifier.clickable { toDoItem.toggleDone() })
        }
        else {
            Text("Incomplete", color = Color.Red, modifier = Modifier.clickable { toDoItem.toggleDone() })
        }
    }
}

@Composable
fun CheckboxWithText(toDoID: Int) {
    CheckboxWithText(listOfToDos[toDoID])
}