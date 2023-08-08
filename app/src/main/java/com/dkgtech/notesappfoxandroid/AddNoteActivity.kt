package com.dkgtech.notesappfoxandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dkgtech.notesappfoxandroid.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}