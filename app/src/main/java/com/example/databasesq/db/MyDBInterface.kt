package com.example.databasesq.db

import com.example.databasesq.adapter.models.User

interface MyDBInterface {
    fun add(user: User)
    fun getAll():List<User>

}