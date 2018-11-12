package com.example.admin.myapplication

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        var name: String,
        var age: Int,
        var gender: String)