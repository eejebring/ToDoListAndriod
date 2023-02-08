package com.example.todolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class ToDoItem {
    var isDone = mutableStateOf(false)
    var title = mutableStateOf("Unnamed to-do")
    var content = mutableStateOf("To-do description")

    constructor() {}
    constructor(title: String) {
        this.title.value = title
    }
    constructor(isDone: Boolean, title: String, content: String) {
        this.isDone.value = isDone
        this.title.value = title
        this.content.value = content
    }

    fun toggleDone() {
        this.isDone.value = !this.isDone.value
    }

    fun clone(): ToDoItem {
        return ToDoItem(this.isDone.value, this.title.value, this.content.value)
    }
}