package com.dkgtech.notesappfoxandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.notesappfoxandroid.database.NoteDatabase
import com.dkgtech.notesappfoxandroid.databinding.ActivityMainBinding
import com.dkgtech.notesappfoxandroid.models.NoteModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var database: NoteDatabase

    lateinit var viewModel: NoteViewModel

    lateinit var adapter: NotesAdapter

    lateinit var selectedNote: NoteModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            intUI()
            viewModel =
                ViewModelProvider(
                    this@MainActivity,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application).get(NoteView)
                )

        }

    }

    fun intUI() {

    }
}