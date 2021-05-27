package com.example.up2date

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = Article.TABLE_NAME)
data class Article(
        @PrimaryKey
        @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "done") var done : Boolean
) {
    companion object {
        const val TABLE_NAME = "Article"
    }
}