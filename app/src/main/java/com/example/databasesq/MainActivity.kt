package com.example.databasesq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databasesq.adapter.MyDataBaseAdapter
import com.example.databasesq.adapter.models.User
import com.example.databasesq.databinding.ActivityMainBinding
import com.example.databasesq.db.MyDBHelper

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myDBHelper: MyDBHelper
    lateinit var adapter: MyDataBaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDBHelper = MyDBHelper(this)
        binding.apply {
            btnSave.setOnClickListener {
                val user = User(name = etName.text.toString().trim(),age = etNumber.text.toString().toInt())
                myDBHelper.add(user)
                Toast.makeText(this@MainActivity, "saved", Toast.LENGTH_SHORT).show()
                onResume()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val list = ArrayList<User>()
        list.addAll( myDBHelper.getAll())
        adapter = MyDataBaseAdapter(list)
        binding.rv.adapter = adapter
    }
}