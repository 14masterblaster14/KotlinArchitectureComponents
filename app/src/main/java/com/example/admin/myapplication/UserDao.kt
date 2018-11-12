package com.example.admin.myapplication

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @get:Query("Select *  from User")
    val all: LiveData<List<User>>

    @Query("Select * from User")
    fun userAll(): DataSource.Factory<Int, User>

    @Query("SELECT * FROM user where name LIKE :name")
    fun findByName(name: String): User

    @Query("SELECT * FROM user where name LIKE :name")
    fun findByNameList(name: String): DataSource.Factory<Int, User>

    @Query("UPDATE user SET name = :name where id = :id")
    fun updateName(name: String, id: Int)

    @Query("SELECT COUNT(*) from user")
    fun countUsers(): Int

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)


}