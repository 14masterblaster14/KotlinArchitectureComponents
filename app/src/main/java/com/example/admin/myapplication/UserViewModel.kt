package com.example.admin.myapplication

import android.app.Application
import android.arch.lifecycle.ViewModel

class UserViewModel(application: Application) : ViewModel() {

    val dao = AppDatabase.getAppDatabase(application).userDao()

    private fun addUser(user: User): User {
        dao.insertAll(user)
        return user
    }

    fun populateWithTestData() {
        var user = User(name = "Ajay", age = 20, gender = "male")
        addUser(user)
        user = User(name = "Shyam", age = 21, gender = "male")
        addUser(user)
    }

    fun countUsers() = dao.countUsers()

    fun updateUser(name: String, id: Int) = dao.updateName(name, id)

    fun getUsersList() = dao.all
}