package com.example.mvvm_.StudentViewModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_.viewmodel.StudentViewModel

class StudentViewModelFactory(val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StudentViewModel(context) as T
    }
}