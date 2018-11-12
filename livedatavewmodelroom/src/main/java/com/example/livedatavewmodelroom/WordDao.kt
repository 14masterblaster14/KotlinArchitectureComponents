package com.example.livedatavewmodelroom

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    //fun getAllWords(): List<Word>
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}