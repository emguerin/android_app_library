package com.imta.eguerin.libraryapp

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("books")
    fun listBooks(): Call<List<Book>>
}
