package com.cr1ss.modulopj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cr1ss.modulopj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = savedInstanceState?.getInt("indice") ?: 0
        binding.ivPerritos.setImageResource(images[i])
        binding.tvDescripcion.text = descripcion[i]

        binding.btnNext.setOnClickListener {
            i++
            if(i==images.size)
                i=0
            binding.ivPerritos.setImageResource(images[i])
            binding.tvDescripcion.text = descripcion[i]
        }
        binding.btnPrev.setOnClickListener{
            i--
            if(i<0)
                i=images.size-1
            binding.ivPerritos.setImageResource(images[i])
            binding.tvDescripcion.text = descripcion[i]
        }
        binding.btnConsulta.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("indice",i)
            startActivity(intent)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("indice", i)
    }
}