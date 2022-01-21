package com.example.mvvm_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_.StudentViewModelFactory.StudentViewModelFactory
import com.example.mvvm_.adapter.StudentAdapter
import com.example.mvvm_.model.Student
import com.example.mvvm_.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel
    private lateinit var recycler_view: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recycler_view = findViewById(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)



        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(application)).get(StudentViewModel::class.java)
        studentViewModel.init()


        studentViewModel.listdata()?.observe(this, {

             recycler_view.adapter=StudentAdapter(it)

        })


    }


}