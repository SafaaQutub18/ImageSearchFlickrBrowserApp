package com.safaa.flickrbrowserapp.Model

data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<PhotoX>,
    val total: Int
)