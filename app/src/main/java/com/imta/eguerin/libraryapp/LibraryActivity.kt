package com.imta.eguerin.libraryapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LibraryActivity : AppCompatActivity(), BookListFrag.OnClickToDetailsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // vide la pile des fragments
        supportFragmentManager.popBackStack()

        // Met la liste de livres dans le fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, BookListFrag())
                .commit()
    }

    override fun onBookSelected(book : Book) {
        val bookDetailFrag = BookDetailFrag()
        val bundle = Bundle()
        bundle.putParcelable("book", book)
        bookDetailFrag.arguments = bundle

        supportFragmentManager.beginTransaction()
                .addToBackStack(BookListFrag::class.java.name)
                .replace(R.id.containerFrameLayout, bookDetailFrag, BookDetailFrag::class.java.name)
                .commit()
    }

}
