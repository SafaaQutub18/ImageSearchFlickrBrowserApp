package com.safaa.flickrbrowserapp.Services

import com.safaa.flickrbrowserapp.Model.Photo
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {
    @GET
    fun getPhotos(@Url url: String?): Call<Photo>
}