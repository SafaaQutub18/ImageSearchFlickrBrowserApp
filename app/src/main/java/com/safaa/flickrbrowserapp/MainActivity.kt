package com.safaa.flickrbrowserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.safaa.flickrbrowserapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var photoList : List<PhotoX>
    val myAdapter : RecyclerViewAdapter by lazy { RecyclerViewAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        photoList = listOf()

        binding.apply {

        // Adapter setting
        recyclerV.adapter = myAdapter
        recyclerV.layoutManager = GridLayoutManager(this@MainActivity,2)

        searchBtn.setOnClickListener {
            recyclerV.isVisible = true
            getAPIdata(photoNameET.text.toString())
        }

            backBtn.setOnClickListener {
                openIV.isVisible = false
                backBtn.isVisible = false
                recyclerV.isVisible = true
            }
        }
    }

    private fun getAPIdata(text:String) {
        //binding.idLoadingPB.isVisible = true
        var url = FlickerAPI.photosURL(text)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(FlickerAPI.baseUrl)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getPhotos(url)
        retrofitData.enqueue(object : Callback<Photo> {

            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {

                photoList =  response.body()!!.photos.photo
                //binding.idLoadingPB.isVisible = false
                myAdapter.setphotoList(photoList)

            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                Log.d("error", "${t}")
            }
//
        })
    }

    fun openPhoto(imageurl: String) {
        binding.apply {
            openIV.isVisible = true
            backBtn.isVisible = true
            recyclerV.isVisible = false

            Glide.with(this@MainActivity)
                .load(imageurl)
                .into(openIV)
        }



    }
}



