package com.lutec.steven.proyectodiseno_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info__desarrolladores.*

class Info_Desarrolladores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info__desarrolladores)

        btn_infoLutec_ID.setOnClickListener{mostrarInfoLutec()}
        btn_infoKrotic_ID.setOnClickListener{mostrarInfoKrotic()}
        btn_infoApik_ID.setOnClickListener{mostrarInfoApik()}
        btn_MenuInformacion_ID.setOnClickListener{volverMenuInformacion()}
    }

    //Las siguientes funciones toman los datos almacenados en el archivo de "strings.xml" y los muestra en panatalla segun la selección del usuario.
    //Adicionalmente mustra la imagen correspondiente a dicha información, estas se obtienen de la carpeta drawable
    //*************************************************************************************************************************
    fun mostrarInfoLutec(){
        text_InfoDesarrolladores_ID.text = getString(R.string.Info_LuTec)
        img_Informacion_ID.setImageResource(R.drawable.foto_info_lutec)
    }
    fun mostrarInfoKrotic(){
        text_InfoDesarrolladores_ID.text = getString(R.string.Info_Krotic)
        img_Informacion_ID.setImageResource(R.drawable.foto_info_krotic)
    }
    fun mostrarInfoApik(){
        text_InfoDesarrolladores_ID.text = getString(R.string.Info_Apik)
        img_Informacion_ID.setImageResource(R.drawable.mascota_saludo)
    }
    //*************************************************************************************************************************
    fun volverMenuInformacion(){
        onBackPressed()
    }
}
