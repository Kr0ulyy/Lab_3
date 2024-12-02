package com.example.lab_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usersList: RecyclerView = findViewById(R.id.userslist)
        val users = arrayListOf<User>()

        users.add(User("Name1", "some@mail.com", "12345", "+1234556"))
        users.add(User("Name2", "some1@mail.com", "142342", "+1234556"))
        users.add(User("Name3", "some2@mail.com", "123342", "+1234556"))


        usersList.layoutManager = LinearLayoutManager(this)
        usersList.adapter = UsersAdapter(users, this)
    }
}