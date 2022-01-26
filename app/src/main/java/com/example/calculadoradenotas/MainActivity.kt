package com.example.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = calcular
        val resultado = resultado
        val limparEdit = limpar

        btCalcular.setOnClickListener{

            if(TextUtils.isEmpty(nota_1.text.toString()) || TextUtils.isEmpty(nota_2.text.toString())){
                Toast.makeText(this, "Insira todas as notas!", Toast.LENGTH_SHORT).show()
            }
            else {
                val nota1 = (nota_1.text.toString()).toDouble()
                val nota2 = (nota_2.text.toString()).toDouble()
                val media = (nota1 + nota2)/2

                if(media>=7) {
                    resultado.text = "Parabéns, Você foi aprovado(a)!\nSua média é: $media"
                    resultado.setTextColor(Color.GREEN)
                }
                else{
                    resultado.text = "Você foi reprovado(a)!\nSua média é: $media"
                    resultado.setTextColor(Color.RED)
                }
            }

        }

        limparEdit.setOnClickListener {
            nota_1.setText("")
            nota_2.setText("")
        }
    }

}
