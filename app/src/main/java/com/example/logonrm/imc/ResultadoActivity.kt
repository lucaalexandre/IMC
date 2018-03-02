package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if(intent !=null){
            val peso = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvValorIMC.text = imc.format(1)

            if (imc <=18.5){
                alterarImagemStatusIMC(R.drawable.abaixo)
                tcStatusIMC.text = "Abaixo do peso"
            }else if(imc <=24.9) {
                alterarImagemStatusIMC(R.drawable.ideal)
                tcStatusIMC.text = "peso ideal"
            }else if(imc <=29.9){
                alterarImagemStatusIMC(R.drawable.sobre)
                tcStatusIMC.text = "Sobre peso"
            }else if(imc <=34.9){
                alterarImagemStatusIMC(R.drawable.obesidade)
                tcStatusIMC.text = "Obesidade I"
            }else if(imc <=39.9){
                alterarImagemStatusIMC(R.drawable.obesidade)
                tcStatusIMC.text = "Obesidade II"
            }else {
                alterarImagemStatusIMC(R.drawable.obesidade)
                tcStatusIMC.text = "Obesidade III"
            }
        }
    }
    fun  alterarImagemStatusIMC(idImagem: Int){
        IVStatusIMC.setImageDrawable( ContextCompat.getDrawable(this,idImagem))
    }

}
