package com.example.programmingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.programmingapp.model.EditProgramming

@Database(entities = [EditProgramming::class], version = 1, exportSchema = false)
abstract class EditProgrammingDatabase : RoomDatabase() {
    abstract val dao: EditProgrammingDao

    companion object {
        @Volatile
        private var instance: EditProgrammingDatabase? = null

        operator fun invoke(context: Context): EditProgrammingDatabase = instance ?: synchronized(Any()) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context): EditProgrammingDatabase {
            return Room.databaseBuilder(
                context,
                EditProgrammingDatabase::class.java,
                "Programming.db"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}