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

class AuthActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val linkToUserList: TextView = findViewById(R.id.link_to_user_list)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_password_auth)
        val buttonAuth: Button = findViewById(R.id.auth_button)
        val buttonDelete: Button = findViewById(R.id.delete_button)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        linkToUserList.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }


        buttonAuth.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || password == "")
                Toast.makeText(this, "Не все поля ввода заполнены. Проверьте введенные данные", Toast.LENGTH_LONG).show()
            else{

                val db = DbHelper(this, null)
                val userAuth = db.getUser(login, password)

                if(userAuth) {
                    Toast.makeText(
                        this,
                        "Выполнен вход в аккаунт $login",
                        Toast.LENGTH_LONG
                    ).show()

                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(
                        this,
                        "Ошибка при входе в аккант",
                        Toast.LENGTH_LONG
                    ).show()

            }

        }

        buttonDelete.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || password == "")
                Toast.makeText(this, "Не все поля ввода заполнены. Проверьте введенные данные", Toast.LENGTH_LONG).show()
            else{

                val db = DbHelper(this, null)
                val userDelete = db.deleteUser(login, password)

                if(userDelete) {
                    Toast.makeText(
                        this,
                        "Аккаунт $login успешно удален",
                        Toast.LENGTH_LONG
                    ).show()

                    userLogin.text.clear()
                    userPassword.text.clear()
                }
                else
                    Toast.makeText(
                        this,
                        "Ошибка при удалении акканта",
                        Toast.LENGTH_LONG
                    ).show()

            }
        }
    }
}