package fastcampus.aop.part3.chapter01_youtube.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fastcampus.aop.part3.chapter01_youtube.R
import fastcampus.aop.part3.chapter01_youtube.model.VideoModel
import kotlinx.android.synthetic.main.item_video.view.*

class VideoAdapter(val callback: (String, String) -> Unit) : ListAdapter<VideoModel, VideoAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: VideoModel) {
            val titleTextView = view.titleTextView
            val subTitleTextView = view.subTitleTextView
            val thumbnailImageView = view.thumbnailImageView

            titleTextView.text = item.title
            subTitleTextView.text = item.subtitle
            Glide.with(thumbnailImageView.context)
                .load(item.thumb).into(thumbnailImageView)

            view.setOnClickListener {
                callback(item.sources, item.title)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<VideoModel>() {
            override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }
        }
    }


}