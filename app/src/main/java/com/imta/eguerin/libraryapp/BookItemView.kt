package com.imta.eguerin.libraryapp

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    var title : TextView? = null
    var price : TextView? = null
    var cover : ImageView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        title = findViewById(R.id.nameTextView)
        price = findViewById(R.id.priceTextView)
        cover = findViewById(R.id.coverImageView)
    }

    fun bindView(book: Book) {
        title?.text = book.title
        price?.text = "Prix : " + book.price + "€"

        Picasso.get()
                .load(book.cover)
                .into(cover)
    }
}
