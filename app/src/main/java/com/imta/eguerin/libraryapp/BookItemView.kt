package com.imta.eguerin.libraryapp

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.imta.eguerin.libraryapp.Book
import com.imta.eguerin.libraryapp.R
import com.squareup.picasso.Picasso

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    var title : TextView? = null
    var price : TextView? = null
    var cover : ImageView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        // TODO findViewById()
        title = findViewById(R.id.nameTextView)
        price = findViewById(R.id.priceTextView)
        cover = findViewById<ImageView>(R.id.coverImageView)
    }

    fun bindView(book: Book) {
        // TODO setText()
        title?.text = book.title
        price?.text = book.price + "€"

        Picasso.get()
                .load(book.cover)
                .into(cover)
    }
}
