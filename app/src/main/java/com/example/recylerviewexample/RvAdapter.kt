package com.example.recylerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recylerviewexample.databinding.ItemFilmBinding

class RvAdapter(var list: ArrayList<User>) : RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    // shablon bilan malumotni bog'lash
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //user ("rasm","marvel 1","desc")
        //user malumot onBind ga keladi
        fun onBind(user: User) {
            val bind = ItemFilmBinding.bind(itemView)
//            Glide.with(itemView).load(user.imgUrl).into(bind.iv)
            bind.tvName.text = user.name
            bind.tvDescription.text = user.description
        }
    }

    // shablon yaratiladi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return MyViewHolder(view)
    }

    // malumot ozi keladi
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    // item ning sonini olish
    override fun getItemCount(): Int {
        return list.size
    }
}