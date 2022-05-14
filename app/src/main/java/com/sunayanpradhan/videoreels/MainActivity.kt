package com.sunayanpradhan.videoreels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2

    lateinit var arrayList: ArrayList<ReelsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager=findViewById(R.id.view_pager)

        supportActionBar?.hide()
        this.theme.applyStyle(R.style.FullScreen,false)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        arrayList= ArrayList()

        arrayList.add(ReelsModel("https://res.cloudinary.com/sunayan02/video/upload/v1652355453/Introducing_Indian_Gamers_-_Ainsi_Bas_La_Vida_Edit_indiangamers_shorts_owek5y.mp4",
            "https://thephotoimages.com/wp-content/uploads/2020/05/Love-DP-Pic-For-Whatsapp.jpg",
        "First"))

        arrayList.add(ReelsModel("https://res.cloudinary.com/sunayan02/video/upload/v1652355393/Technologies_used_in_IPL_sctmj8.mp4",
            "https://thephotoimages.com/wp-content/uploads/2020/05/Love-DP-Pic-For-Whatsapp.jpg",
            "Second"))

        arrayList.add(ReelsModel("https://res.cloudinary.com/sunayan02/video/upload/v1652355376/Why_Most_5_Star_Hotels_are_Owned_By_Politicians_jm8exi.mp4",
            "https://thephotoimages.com/wp-content/uploads/2020/05/Love-DP-Pic-For-Whatsapp.jpg",
            "Third"))



        var adapter= ReelsAdapter(arrayList,this)

        viewPager.adapter=adapter



    }
}