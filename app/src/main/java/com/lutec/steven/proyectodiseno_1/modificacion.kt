package com.lutec.steven.proyectodiseno_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_modificacion.*

class modificacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificacion)

        btn_Regresar_Modif.setOnClickListener{volverMenuPrincipal()}
    }
    //****************Implementar función para la modificacion de las tablas con nombre de proyectos.****************

    fun volverMenuPrincipal(){
        onBackPressed()
    }
}
