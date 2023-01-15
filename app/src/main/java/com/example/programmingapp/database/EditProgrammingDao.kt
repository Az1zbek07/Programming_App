package com.example.programmingapp.database

import android.widget.EditText
import androidx.room.*
import com.example.programmingapp.model.EditProgramming

@Dao
interface EditProgrammingDao {

    @Query("SELECT * FROM EditProgramming ORDER BY id DESC")
    fun getAllClubs(): List<EditProgramming>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveClub(editProgramming: EditProgramming)

    @Update
    fun updateClub(editProgramming: EditProgramming)

    @Delete
    fun deleteClub(editProgramming: EditProgramming)
}