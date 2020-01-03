package com.welcome.jetpack_learn.data.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.welcome.jetpack_learn.data.bean.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User ORDER BY name COLLATE NOCASE ASC")
    fun queryUsersByName(): DataSource.Factory<Int, User>

    @Insert
    fun insert(user: List<User>)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}