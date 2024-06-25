package com.lutec.steven.proyectodiseno_1

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nombre_proyecto.*

class NombreProyecto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre_proyecto)

        btn_regresar_NameProy.setOnClickListener{volverCrear()}
    }

    fun volverCrear(){
        onBackPressed()
    }


}
