package com.sunayanpradhan.videoreels

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ReelsAdapter(val list: List<ReelsModel>,val context: Context):RecyclerView.Adapter<ReelsAdapter.ViewHolder>() {

    lateinit var mp:MediaPlayer


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val reelsVideo:VideoView=itemView.findViewById(R.id.reels_video)
        val profile:ImageView=itemView.findViewById(R.id.profile)
        val profileName:TextView=itemView.findViewById(R.id.profile_name)
        val reelsPlay:ImageView=itemView.findViewById(R.id.reels_play)
        val progressBar:ProgressBar=itemView.findViewById(R.id.progress_bar)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reels_layout,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem=list[position]

        holder.reelsVideo.setVideoPath(currentItem.reels)

        mp= MediaPlayer()


        holder.reelsVideo.setOnPreparedListener {

            mp=it

            it.start()
            holder.progressBar.visibility = View.GONE
        }








        holder.reelsVideo.setOnCompletionListener {


            mp=it
            holder.reelsVideo.start()

        }

        holder.itemView.setOnClickListener {

            if (mp.isPlaying) {

                mp.pause()
                holder.reelsPlay.visibility=View.VISIBLE

            }

            else{

                mp.start()
                holder.reelsPlay.visibility=View.GONE


            }

        }




        Glide.with(context).load(currentItem.profile).into(holder.profile)

        holder.profileName.text=currentItem.profileName






    }

    override fun getItemCount(): Int {
        return list.size
    }
}