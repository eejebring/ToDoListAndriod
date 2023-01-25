package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.ToDoCompose
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    layout()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var col = Color.Red
    Text(text = "Hello $name!", color = col)
}

@Composable
fun layout () {
    val listOfToDos = remember { mutableListOf<ToDoItem>(ToDoItem("Do the thing")) }
    Column  {
        Row {
            Greeting("Android")
            Greeting("Hello World!")
        }
        Divider(color = Color.Black)
        Row {
            Greeting(listOfToDos.value.getTitle())
        }
        Divider()
        ToDoCompose(listOfToDos.value)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoListTheme {
        layout()
    }
}