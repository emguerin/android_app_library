package com.imta.eguerin.libraryapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class BookListFrag : Fragment() {

    private var listener: OnClickToDetailsListener? = null
    private var bookAdapter: BookAdapter? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        when (context) {
            is OnClickToDetailsListener -> listener = context
            else -> throw Exception("...")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_book_frag, container, false)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree())

        // TODO build Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // TODO create a service
        val api = retrofit.create(Api::class.java)

        // TODO listBooks()
        val booksCall = api.listBooks()

        // mylistadapter = bookadapter  and fill book adapter
        val list = view.findViewById<ListView>(R.id.bookListViewFrag)
        this.bookAdapter = BookAdapter(view.context, emptyList())
        list.adapter = bookAdapter
        list.setOnItemClickListener { parent, view, position, id ->
            getBookDetails(position)
        }
        // TODO enqueue call and display book title
        booksCall.enqueue(
                object : Callback<List<Book>> {

                    override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {

                        Timber.i("Success")
                        // TODO log books
                        val booksList = response.body()

                        booksList?.apply {
                            this.forEach {
                                Timber.i("Title : $it")
                            }
                        }
                        // TODO display book as a list
                        bookAdapter?.changeList(booksList!!)
                    }

                    override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                        // nothing atm
                        Timber.i("Failure")
                    }

                }
        )
        return view
    }

    private fun getBookDetails(position: Int) {
//        bookAdapter?.apply {
//            val book = this.getItem(position)
//        }
        listener?.apply { onNext() }
    }

    interface OnClickToDetailsListener {
        fun onNext()
    }

}
