package com.example.mvvm_.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.mvvm_.model.Student
import com.example.mvvm_.repositort.StudentRepository

class StudentViewModel(val context: Context):ViewModel() {

    private var studentlist: MutableLiveData<List<Student>>? = null
    private var mRepo: StudentRepository? = null

    fun init() {
        if (studentlist != null) {
            return
        }
        mRepo = StudentRepository(context).instance
        studentlist = mRepo?.getstudentdata()

//        Toast.makeText(context,studentlist.toString(),Toast.LENGTH_SHORT).show()
    }

    fun listdata(): LiveData<List<Student>>? {
        return studentlist
    }






}