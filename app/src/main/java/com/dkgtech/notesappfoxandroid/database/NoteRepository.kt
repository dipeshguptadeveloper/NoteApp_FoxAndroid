package com.dkgtech.notesappfoxandroid.database

import androidx.lifecycle.LiveData
import com.dkgtech.notesappfoxandroid.models.NoteModel

class NoteRepository(val noteDao: NoteDao) {

    val getAllNotes: LiveData<List<NoteModel>> = noteDao.getAllNotes()

    suspend fun addNote(newNote: NoteModel) {
        noteDao.addNote(newNote)
    }

    suspend fun deleteNote(noteModel: NoteModel) {
        noteDao.deleteNote(noteModel)
    }

    suspend fun updateNote(noteModel: NoteModel) {
        noteDao.updateNote(noteModel.id, noteModel.title, noteModel.desc)
    }

}