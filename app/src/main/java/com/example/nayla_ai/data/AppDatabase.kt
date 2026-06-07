package com.example.nayla_ai.data

import android.content.Context
import androidx.room.*
import com.example.nayla_ai.Message.MessageDao
import com.example.nayla_ai.Message.MessageModel
import com.example.nayla_ai.Review.ReviewDao
import com.example.nayla_ai.Review.ReviewModel
import com.example.nayla_ai.data.dao.NoteDao
import com.example.nayla_ai.data.entity.Note

@Database(entities = [Note::class, MessageModel::class, ReviewModel::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun messageDao(): MessageDao
    abstract fun reviewDao(): ReviewDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
        }
    }
}