package com.lutec.steven.proyectodiseno_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info__programacion.*

class Info_Programacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info__programacion)

        btn_Instrucciones_IP.setOnClickListener{mostrarInfoInstrucciones()}
        btn_ProcesoProgramacion_IP.setOnClickListener{mostrarInfoProcProgramacion()}
        btn_Regresar_IP.setOnClickListener{volverMenuInformacion()}
    }

    //Las siguientes funciones toman los datos almacenados en el archivo de "strings.xml" y los muestra en panatalla segun la selección del usuario.
    //Adicionalmente mustra la imagen correspondiente a dicha información, estas se obtienen de la carpeta drawable
    //*************************************************************************************************************************
    fun mostrarInfoInstrucciones(){
        txt_InfoProg.text = getString(R.string.Info_Instrucciones)
        img_InfoProg.setImageResource(R.drawable.info_instrucciones)
    }
    fun mostrarInfoProcProgramacion(){
        txt_InfoProg.text = getString(R.string.Info_procesoProgramacion)
        img_InfoProg.setImageResource(R.drawable.info_programacion)
    }
    //*************************************************************************************************************************
    fun volverMenuInformacion(){
        onBackPressed()
    }
}
