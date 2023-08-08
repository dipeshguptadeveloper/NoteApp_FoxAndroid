package com.dkgtech.notesappfoxandroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dkgtech.notesappfoxandroid.models.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(newNote: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

    @Query("update notes_table set title= :title, `desc`= :desc where id=:id")
    suspend fun updateNote(id: Int, title: String, desc: String)

    @Query("select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<NoteModel>>
}