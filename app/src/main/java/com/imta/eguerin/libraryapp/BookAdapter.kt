package com.imta.eguerin.libraryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.imta.eguerin.libraryapp.Book
import com.imta.eguerin.libraryapp.R

class BookAdapter(context: Context, private var books: List<Book>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        // not used here
    }

    override fun getCount(): Int = books.size

    override fun getItem(position: Int): Book = books[position]

    override fun getItemId(position: Int): Long = books[position].hashCode().toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view : BookItemView = when (convertView) {
            null -> inflater.inflate(R.layout.custom_view_item_book, parent, false)
            else -> convertView
        } as BookItemView

        view.bindView(getItem(position))
        return view
    }

    fun changeList(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }
}
