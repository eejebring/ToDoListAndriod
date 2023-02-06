package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todolist.ui.theme.ToDoCompose
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    start()
                }
            }
        }
    }
}

@Composable
fun start() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "layout") {
        composable("layout") { layout(navController) }
        composable("newToDo") { Heading("hi") }
        composable("ToDoDetails/{ToDoID}", arguments = listOf(navArgument("ToDoID") {type = NavType.IntType})) { args -> Heading(args.arguments?.getInt("ToDoID").toString()) }
    }
}

@Composable
fun layout(navController: NavHostController) {
    val listOfToDos = remember {
        mutableListOf(ToDoItem("Do the thing"), ToDoItem("the other thing"))
    }
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Heading("Your To-do list")
        }
        Row {
            Button(
                onClick = { navController.navigate("newToDo")},
            ) {
                Text("New: to-do")
            }
        }
        for (toDoID in 0..listOfToDos.lastIndex) {
            ToDoCompose(listOfToDos[toDoID], toDoID, navController)
        }
    }
}

@Composable
fun Heading(text: String) {
    Text(text = text,
        style = MaterialTheme.typography.h2
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    ToDoListTheme {
        layout(navController)
    }
}