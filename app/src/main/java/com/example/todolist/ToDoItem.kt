package com.example.todolist

class ToDoItem {
    var isDone = false
    private val title: String

    constructor(title: String) {
        this.title = title
    }

    fun getTitle(): String {
        return this.title
    }
    fun toggleDone() {
        this.isDone = !this.isDone
    }
}