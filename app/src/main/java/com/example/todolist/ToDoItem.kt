package com.example.todolist

import androidx.compose.runtime.mutableStateOf

class ToDoItem {
    var isDone = mutableStateOf(false)
    var title = mutableStateOf("Unnamed to-do")
    var description = mutableStateOf("To-do description")

    constructor() {}
    constructor(title: String) {
        this.title.value = title
    }
    constructor(isDone: Boolean, title: String, description: String) {
        this.isDone.value = isDone
        this.title.value = title
        this.description.value = description
    }

    fun toggleDone() {
        this.isDone.value = !this.isDone.value
    }

    fun clone(): ToDoItem {
        return ToDoItem(this.isDone.value, this.title.value, this.description.value)
    }
}