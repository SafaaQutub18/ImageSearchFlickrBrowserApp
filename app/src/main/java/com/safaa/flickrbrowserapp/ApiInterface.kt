package com.safaa.flickrbrowserapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {
    @GET
    fun getPhotos(@Url url: String?): Call<Photo>
}