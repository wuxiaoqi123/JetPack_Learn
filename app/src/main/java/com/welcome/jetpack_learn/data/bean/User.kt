package com.welcome.jetpack_learn.data.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)