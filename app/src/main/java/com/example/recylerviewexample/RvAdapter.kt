package com.example.recylerviewexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recylerviewexample.databinding.ItemFilmBinding

class RvAdapter(var list: ArrayList<User>, var onClick: OnClickListener) :
    RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    // shablon bilan malumotni bog'lash
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User, position: Int) {
            val bind = ItemFilmBinding.bind(itemView)
            val anim = AnimationUtils.loadAnimation(itemView.context, R.anim.item_anim)
            itemView.startAnimation(anim)

            bind.tv1.text = user.name
            bind.tv2.text = user.password

            bind.root.setOnClickListener {
                onClick.onRootClick(user, position)
            }
            bind.ivDelete.setOnClickListener {
                onClick.onclickUser(user, position)
            }
        }
    }

    // shablon yaratiladi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return MyViewHolder(view)
    }

    // malumot ozi keladi
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    // item ning sonini olish
    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListener {
        fun onclickUser(user: User, position: Int)

        fun onRootClick(user: User, position: Int)
    }
}