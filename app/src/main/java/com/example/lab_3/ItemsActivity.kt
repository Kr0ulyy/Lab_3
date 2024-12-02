package com.example.lab_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsList: RecyclerView = findViewById(R.id.itemslist)
        val items = arrayListOf<Item>()

        items.add(Item(1, "laptop", "Lenovo ThinkPro Z15", "Мощный ноутбук для работы и развлечений",
            "Производительный 15-дюймовый ноутбук с процессором Intel i7, SSD на 1 ТБ, графикой NVIDIA RTX и IPS-дисплеем для плавной работы, игр и создания контента", 1000))
        items.add(Item(2, "phone", "Galaxy Neo S12", "Смартфон с впечатляющим экраном и камерой",
            "Смартфон с 6.7-дюймовым AMOLED-дисплеем, тройной камерой на 108 Мп, аккумулятором 5000 мАч, поддержкой 5G и памятью на 256 ГБ — стиль и производительность", 450))
        items.add(Item(3, "mouse", "Logitech G305 Lightspeed", "Легкая игровая мышь с высокой точностью",
            "Удобная беспроводная мышь с сенсором Hero, временем работы до 250 часов, 6 программируемыми кнопками и компактным дизайном для игр и работы на любом устройстве", 45))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}