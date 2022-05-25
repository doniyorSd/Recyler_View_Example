package com.example.recylerviewexample

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recylerviewexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<User>()
    lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        adapter = RvAdapter(list, object : RvAdapter.OnClickListener {
            override fun onclickUser(user: User, position: Int) {
                list.removeAt(position)
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position, list.size)
                Toast.makeText(this@MainActivity, "$position item Deleted", Toast.LENGTH_SHORT).show()
            }

            override fun onRootClick(user: User, position: Int) {
                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("user",user)
                startActivity(intent)
            }
        })

        binding.rv.adapter = adapter


        binding.btn.setOnClickListener {
            val name = binding.name.text.toString()
            val password = binding.password.text.toString()

            val user = User(name, password)
            list.add(user)
            adapter.notifyItemInserted(list.size)
        }
    }

    private fun setData() {
        for (i in 0 until 100){
            list.add(User("Doniyor","$i 1231"))
        }
    }

}