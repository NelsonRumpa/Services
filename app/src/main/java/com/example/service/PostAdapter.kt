package com.example.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val list:ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    lateinit var tvText: TextView

    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(postResponse: PostResponse) {
            with(itemView) {
                val text = "id: ${postResponse.id}\n" +
                        "nama: ${postResponse.nama}\n" +
                        "nim: ${postResponse.nim}\n" +
                        "alamat: ${postResponse.alamat}\n" +
                        "email: ${postResponse.email}\n" +
                        "foto: ${postResponse.foto}\n" +
                        "title: ${postResponse.title}\n" +
                        "text: ${postResponse.text}"
                tvText.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}