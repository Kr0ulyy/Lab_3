package com.example.lab_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(var users: List<User>, var context: Context) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>(){

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val login: TextView = view.findViewById(R.id.user_list_login)
        val email: TextView = view.findViewById(R.id.user_list_mail)
        val pass: TextView = view.findViewById(R.id.user_list_pass)
        val phone: TextView = view.findViewById(R.id.user_list_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.login.text = users[position].login
        holder.email.text = users[position].email
        holder.pass.text = users[position].pass
        holder.phone.text = users[position].phoneNumb
    }
}