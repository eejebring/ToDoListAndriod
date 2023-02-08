package com.example.todolist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ToDoDetails(toDoID: Int, navController: NavController) {
    if (!(listOfToDos.lastIndex < toDoID)) { //makes sure the app does not crash when pressing delete
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Heading(listOfToDos[toDoID].title.value)
            }
            CheckboxWithText(toDoID)
            Row (modifier = Modifier.padding(10.dp)) {
                Text(listOfToDos[toDoID].content.value)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = {
                    navController.navigate("ToDoEdit/$toDoID")
                }) {
                    Text("Edit")
                }
                Button(onClick = {
                    navController.popBackStack()
                    listOfToDos.removeAt(toDoID)
                }) {
                    Text("Delete")
                }
            }
        }
    }

}

