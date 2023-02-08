package com.example.todolist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ToDoEdit(toDoItem: ToDoItem, navController: NavController, saveFunction: (ToDoItem) -> Unit) {
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text("Title:")
            TextField(toDoItem.title.value, { value -> toDoItem.title.value = value })
            Row (modifier = Modifier.padding(10.dp)) {
                Text("Description:")
                TextField(toDoItem.content.value, { value -> toDoItem.content.value = value })
            }
            Button(onClick = {
                saveFunction(toDoItem)
                navController.popBackStack()
            }) {
                Text("Save")
            }
        }
    }
}