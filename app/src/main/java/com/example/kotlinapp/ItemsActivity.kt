package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "linens", "Постільна білизна LightHouse", "Комплект постільної білизни із фланелі LightHouse Checks.",
            "Виробник: LightHouse (Турция), тканина: фланель (100% бавовна), упаковка: ПВХ-сумка, колір: зелений, підковдра: на ґудзиках", 2229))

        items.add(Item(2, "plaid", "Плед новорічний", "Плед новорічний синій бавовняний SoundSleep Angels - м'який і бархатистий плед з лімітованої новорічної колекції Angels бренду SoundSleep.",
            "Виробник: SoundSleep (Україна), щільність: 350г / м2, склад: 60% бавовна + 40% поліестер, колір: синій", 552))
        items.add(Item(3, "pillow", "Подушка антиалергенна", "Подушка антиалергенна: Лебединий пух у чохлі з мікрофібри",
            "Виробник: Руно (Україна), упаковка: ПВХ, колір: білий, розмір: 50x70 см, чохол: мікрофібра (100% поліестер)", 436))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}