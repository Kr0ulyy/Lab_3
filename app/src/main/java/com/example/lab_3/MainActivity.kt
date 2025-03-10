package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val userPhoneNumb: EditText = findViewById(R.id.user_phone_nunb)
        val buttonReg: Button = findViewById(R.id.reg_button)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity2::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            val phoneNumber = userPhoneNumb.text.toString().trim()

            if (login == "" || email == "" || phoneNumber == "" || password == "")
                Toast.makeText(this, "Не все поля ввода заполнены. Проверьте введенные данные", Toast.LENGTH_LONG).show()
            else{
                val user = User(login, email, password, phoneNumber)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Данные сохранены. Добро пожаловать, $login!", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
                userPhoneNumb.text.clear()
            }

        }
    }
}