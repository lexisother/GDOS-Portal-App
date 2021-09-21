package com.alyxia.gdos_portal_app.structures

data class UserDB(
    var users: List<User>
)

data class User(
    val name: String,
    val email: String,
    val password: String,
    val todo: List<TodoItem>
)

data class TodoItem(
    val name: String,
    val content: String
)
