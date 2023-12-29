package com.example.thirdhometask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thirdhometask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val myAdapter = FrogAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeButton.setOnClickListener{
            val intent = Intent(this, InfoActivity::class.java)
            startActivityForResult(intent, 1001)
        }

        init()

    }

    fun init(){
        binding.apply {
            myList.adapter = myAdapter
            addButton.setOnClickListener{
                var myFroggo = Frog()
                myAdapter.addFrog(myFroggo)
            }
        }
    }
}