package com.sunayanpradhan.videoreels

data class ReelsModel(
    var reels:String,
    var profile:String,
    var profileName:String
)
{
    constructor():this(
        "",
        "",
    ""
    )
}
