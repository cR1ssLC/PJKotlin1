package com.cr1ss.modulopj

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cr1ss.modulopj.databinding.ActivityMain2Binding
import com.cr1ss.modulopj.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private var i=0
    private val images = listOf(R.drawable.dog_1,
        R.drawable.dog_2,
        R.drawable.dog_3,
        R.drawable.dog_4,
        R.drawable.dog_5,
        R.drawable.dog_6,
        R.drawable.dog_7,
        R.drawable.dog_8,
        R.drawable.dog_9,
        R.drawable.dog_10,
        R.drawable.dog_11,
        R.drawable.dog_12,
        R.drawable.dog_13,
        R.drawable.dog_14,
        R.drawable.dog_15)

    private val descripcion= listOf<String>("Nombre: Tobi \nEdad: 5 Años",
        "Nombre: Coco \nEdad: 8 Años",
        "Nombre: Thor \nEdad: 2 Años",
        "Nombre: Max \nEdad: 4 Años",
        "Nombre: Rocky \nEdad: 6 Años",
        "Nombre: Simba \nEdad: 2 Años",
        "Nombre: Zeus \nEdad: 4 Años",
        "Nombre: Luna \nEdad: 3 Años",
        "Nombre: Noa \nEdad: 3 Años",
        "Nombre: Taco \nEdad: 5 Años",
        "Nombre: Congo \nEdad: 2 Años",
        "Nombre: Kira \nEdad: 3 Años",
        "Nombre: Jack \nEdad: 4 Años",
        "Nombre: Cookie \nEdad: 2 Años",
        "Nombre: Maya \nEdad: 3 Años"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        i = savedInstanceState?.getInt("indice") ?: 0

        val indice = intent.extras?.getInt("indice")
        if (indice != null)
            i= indice

        binding.tv1.text = descripcion[i]
        binding.iv1.setImageResource(images[i])

        binding.btn1.setOnClickListener {
            val email = listOf<String>("adopta_no_compres@gmail.com")
            val name = binding.et1.text.toString()
            val number = binding.et2.text.toString()
            val asunto = "Hola soy $name y mi numero es $number"
            val contenido = "Quiero adoptar a: \n"+descripcion[i]+"\n"+binding.et3.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL, email.toTypedArray())
            intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
            intent.putExtra(Intent.EXTRA_TEXT, contenido)

            startActivity(intent)
        }


    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("indice", i)
    }
}