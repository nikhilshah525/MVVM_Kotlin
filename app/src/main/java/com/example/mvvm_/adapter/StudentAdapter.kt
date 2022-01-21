package com.example.mvvm_.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_.R
import com.example.mvvm_.model.Student

class StudentAdapter(private  val studentlist:List<Student>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem,parent,false)
        return  StudentViewHolder(itemview)


    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentitem=studentlist[position]
        holder.id.text="ID:"+currentitem.id
        holder.name.text="Name:"+currentitem.name
        holder.email.text="Email:"+currentitem.email
        holder.password.text="Password:"+currentitem.password
    }

    override fun getItemCount(): Int {
       return studentlist.size
    }



    class StudentViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        val id:TextView =itemview.findViewById(R.id.id)
        val name:TextView =itemview.findViewById(R.id.name)
        val email:TextView =itemview.findViewById(R.id.email)
        val password:TextView =itemview.findViewById(R.id.password)


    }

}