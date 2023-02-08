package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Start()
                }
            }
        }
    }
}

@Composable
fun Start() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "layout") {
        composable("layout") {
            ToDoListView(navController)
        }
        composable("newToDo") {
            ToDoEdit(ToDoItem(), navController) {
                    toDoItem ->  listOfToDos.add(toDoItem)
            }
        }
        composable("ToDoDetails/{ToDoID}", arguments = listOf(navArgument("ToDoID") {type = NavType.IntType})) {
                args -> ToDoDetails(args.arguments!!.getInt("ToDoID"), navController)
        }
        composable("ToDoEdit/{ToDoID}", arguments = listOf(navArgument("ToDoID") {type = NavType.IntType})) {
                args -> ToDoEdit( listOfToDos[args.arguments!!.getInt("ToDoID")].clone(), navController) {
                    toDoItem ->  listOfToDos[args.arguments!!.getInt("ToDoID")] = toDoItem
            }
        }
    }
}

val listOfToDos = mutableListOf(ToDoItem("Do the thing"), ToDoItem("the other thing"))

@Composable
fun ToDoListView(navController: NavHostController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(rememberScrollState())) {
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
            ToDoCompose(toDoID, navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    ToDoListTheme {
        ToDoListView(navController)
    }
}