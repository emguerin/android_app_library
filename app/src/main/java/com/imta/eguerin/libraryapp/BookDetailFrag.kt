package com.imta.eguerin.libraryapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import timber.log.Timber

class BookDetailFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_book_frag, container, false)

        arguments?.apply {
            val book : Book = getParcelable("book")

            Timber.i("book : " + book.title)
            val titleView = view.findViewById<TextView>(R.id.titleView)
            val priceView = view.findViewById<TextView>(R.id.priceView)
            val coverView = view.findViewById<ImageView>(R.id.coverView)
            val descView = view.findViewById<TextView>(R.id.descView)

            titleView?.text = book.title
            priceView?.text = "Disponible au prix de " + book.price + "€"
            descView?.text = generateSynopsis(book.synopsis)

            Picasso.get()
                    .load(book.cover)
                    .into(coverView)
        }
        return view
    }

    private fun generateSynopsis(synopsisArray : Array<String>) : String {
        var synopsis = ""

        synopsisArray.forEach { synopsisPart ->
            synopsis += synopsisPart
        }
        return synopsis
    }
}
