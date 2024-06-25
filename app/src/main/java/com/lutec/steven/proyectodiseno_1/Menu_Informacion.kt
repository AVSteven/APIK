package com.lutec.steven.proyectodiseno_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu__informacion.*

class Menu_Informacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu__informacion)

        btn_desarrolladores_MI.setOnClickListener{mostrarDesarrolladores()}
        btn_Programacion_MI.setOnClickListener{mostrarProgramacion()}
        btn_MenuPrincipal_MI.setOnClickListener{volver_MenuPrincipal()}
    }

    //Debido a las caracteristicas de esta actividad, unicamente se redirecciona al usuario según la selección.
    //*************************************************************************************************************************
    fun mostrarDesarrolladores(){
        val intent = Intent(this, Info_Desarrolladores::class.java)
        startActivity(intent)
    }
    fun mostrarProgramacion(){
        val intent = Intent(this, Info_Programacion::class.java)
        startActivity(intent)
    }
    //*************************************************************************************************************************
    fun volver_MenuPrincipal(){
        onBackPressed()
    }
}
