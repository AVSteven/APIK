package com.lutec.steven.proyectodiseno_1

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {

    private val SplashScreen=3000; //Tiempo que tarda la pantalla de presentacion cambiar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//-----------------------------------SplashScreen------------------------------------------
/*  A continuacion se desarrolla el codigo para permanecer en una pantalla(actividad)
y desplazarce a otra automaticamente, al transcurrir cierto tiempo.*/
        Handler().postDelayed({
            startActivity(Intent(this,NombreUsuario::class.java))
            finish()
        },SplashScreen.toLong())
//-----------------------------------------------------------------------------------------
    }
}
