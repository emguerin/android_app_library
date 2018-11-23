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
                .replace(R.id.list_book_fragment, BookListFrag())
                .commit()

        // TODO régler problème clic
        // TODO implémentation page detail (penser au synopsis)
        // TODO un peu de view
    }

    override fun onNext() {
        supportFragmentManager.beginTransaction()
                .addToBackStack(BookListFrag::class.java.name)
                .replace(R.id.list_book_fragment, BookDetailFrag(), BookDetailFrag::class.java.name)
                .commit()
    }

}
