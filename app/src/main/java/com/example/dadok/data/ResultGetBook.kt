package com.example.dadok.data

data class ResultGetBook(
    //Img, Title, Author, Publisher

    //Request
    var d_title: String = "",
    var d_auth: String = "",
    //Result
    var image: String = "",
    var title: String = "",
    var author: String = "",
    var publisher: String = ""
//TODO - var items: List<Items> 이걸 쓰는 게 좋을까?
)

