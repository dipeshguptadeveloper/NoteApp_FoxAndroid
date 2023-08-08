package com.dkgtech.notesappfoxandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.notesappfoxandroid.databinding.NoteRowBinding
import com.dkgtech.notesappfoxandroid.models.NoteModel

class RecyclerNoteAdapter(val context: Context, val noteList: ArrayList<NoteModel>) :
    RecyclerView.Adapter<RecyclerNoteAdapter.ViewHolder>() {
    class ViewHolder(val binding: NoteRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            txtNoteTitle.text = noteList[position].title
            txtNoteDesc.text = noteList[position].desc

        }
    }
}