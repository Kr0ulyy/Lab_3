package com.example.lab_3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper (val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app_reg", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT NULL, login TEXT, email TEXT, password TEXT, phoneNumb TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.pass)
        values.put("phoneNumb", user.phoneNumb)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND password = '$pass'", null)
        return result.moveToFirst()
    }

    fun deleteUser(login: String, pass: String): Boolean {
        val db = this.writableDatabase

        val deletedRows: Int = db.delete("users", "login = ? AND password = ?", arrayOf(login, pass))
        return deletedRows > 0
    }
 }