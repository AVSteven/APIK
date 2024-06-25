package com.lutec.steven.proyectodiseno_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eliminar.*

class Eliminar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)

        btn_Regresar_Elim.setOnClickListener{volverMenuPrincipal()}
    }

    //****************Implementar función para la eliminacion de las tablas con nombre de proyectos.****************

    fun volverMenuPrincipal(){
        onBackPressed()
    }
}
