package com.example.sayitahminoyunu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var rastgeleSayi = 0
    private var denemeSayisi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Arayüz elemanlarını tanımla
        val editTextTahmin = findViewById<EditText>(R.id.editTextTahmin)
        val buttonTahminEt = findViewById<Button>(R.id.buttonTahminEt)
        val textViewSonuc = findViewById<TextView>(R.id.textViewSonuc)

        // Rastgele 1-100 arasında sayı üret
        rastgeleSayi = Random.nextInt(1, 101)

        buttonTahminEt.setOnClickListener {
            val tahminStr = editTextTahmin.text.toString()

            if (tahminStr.isEmpty()) {
                Toast.makeText(this, "Lütfen bir sayı girin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tahmin = tahminStr.toInt()
            denemeSayisi++

            when {
                tahmin < rastgeleSayi -> {
                    textViewSonuc.text = "Daha büyük bir sayı deneyin!"
                }
                tahmin > rastgeleSayi -> {
                    textViewSonuc.text = "Daha küçük bir sayı deneyin!"
                }
                else -> {
                    textViewSonuc.text = "🎉 Tebrikler! $denemeSayisi denemede bildiniz."
                    Toast.makeText(this, "Yeni oyun başlıyor...", Toast.LENGTH_LONG).show()
                    editTextTahmin.text.clear()
                    rastgeleSayi = Random.nextInt(1, 101)
                    denemeSayisi = 0
                }
            }
        }
    }
}
