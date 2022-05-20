package com.example.recylerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recylerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        val adapter = RvAdapter(list)
        //LinearLayoutManager
//        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        val manager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapter
    }

    private fun setData() {
        for (i in 0 until 50) {
            list.add(
                User(
                    "https://images.thedirect.com/media/article_full/mcu-movies.jpg",
                    "Marvel1",
                    "Kino yaxshi",
                )
            )
            list.add(
                User(
                    "https://images.thedirect.com/media/article_full/eternals-reviews-rotten-mcu.jpg",
                    "Marvel 2",
                    "Kino zo'r"
                )
            )
            list.add(
                User(
                    "https://images.thedirect.com/media/article_full/mcu-movies.jpg",
                    "Marvel 3",
                    "Kino yomon"
                )
            )
        }
    }
}