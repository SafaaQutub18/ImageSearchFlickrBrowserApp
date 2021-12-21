package com.safaa.flickrbrowserapp

import android.util.Log

class FlickerAPI {
    companion object{
        val baseUrl = "https://www.flickr.com/services/"
        val APIkey = "72ded5782b2a4acbc2664e37954a25e7"

        fun photosURL(text:String): String{
            var url = "rest"
            url += "?method=flickr.photos.search"
            url += "&text=$text"
            url += "&api_key=" + APIkey
            url += "&format=json"
            url += "&nojsoncallback=1"
            url += "&extras=date_taken,url_h"
            Log.d("main",url)
            return url
        }

    }

    }
