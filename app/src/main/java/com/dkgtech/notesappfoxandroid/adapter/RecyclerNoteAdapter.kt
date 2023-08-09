package com.dkgtech.notesappfoxandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.notesappfoxandroid.R
import com.dkgtech.notesappfoxandroid.databinding.NoteRowBinding
import com.dkgtech.notesappfoxandroid.models.NoteModel
import kotlin.random.Random

class RecyclerNoteAdapter(
    val context: Context,
    val noteList: ArrayList<NoteModel>,
    val fullList: ArrayList<NoteModel>,
    val listner: notesItemClickListner
) :
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
            txtNoteTitle.isSelected = true
            txtNoteDesc.text = noteList[position].desc
            txtNoteDate.text = noteList[position].date
            txtNoteDate.isSelected = true
            cardLayout.setCardBackgroundColor(
                holder.itemView.resources.getColor(
                    randomColor(),
                    null
                )
            )

            cardLayout.setOnClickListener {
                listner.onItemClicked(noteList[holder.adapterPosition])
            }


        }
    }

    fun randomColor(): Int {

        val colorList = ArrayList<Int>()
        colorList.add(R.color.black)
        colorList.add(R.color.white)

        val seed = System.currentTimeMillis().toInt()
        val randomIndex = Random(seed).nextInt(colorList.size)
        return colorList[randomIndex]
    }

    interface notesItemClickListner {

        fun onItemClicked(noteModel: NoteModel)
        fun onLongItemClicked(noteModel: NoteModel, cardView: CardView)
    }

    fun updateList(newList: List<NoteModel>) {
        fullList.clear()
        fullList.addAll(newList)

        noteList.clear()
        noteList.addAll(fullList)
        notifyDataSetChanged()
    }

    fun filterList(search: String) {

        noteList.clear()
        for (item in fullList) {
            if (item.title.lowercase().contains(search.lowercase()) || item.desc.lowercase()
                    .contains(search.lowercase())
            ) {
                noteList.add(item)
            }
        }
    }
}