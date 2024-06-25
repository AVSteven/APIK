package com.lutec.steven.proyectodiseno_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_principal.*

class MenuPrincipal : AppCompatActivity() {

    var flag_seleccion:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)



        getNameUsuario()
        btn_crear_MP.setOnClickListener{mostrarInfo_Crear()}
        btn_modificar_MP.setOnClickListener{mostrarInfo_Modificar()}
        btn_eliminar_MP.setOnClickListener{mostrarInfo_Eliminar()}
        btn_informacion_MP.setOnClickListener{mostrarInfo_Informacion()}
        btn_continuar_mp.setOnClickListener{continuarActividad()}
    }

    fun getNameUsuario(){
        val bundle = intent.extras
        val nUsuario = bundle.get("name")
        Text_Nombre_MP.text = getString(R.string.nombre_usuario_actual, nUsuario)
    }

    //Las siguientes funciones establecen el texto que se muestra segun la selección del usuario en el menu principal. Adicionalmente
    //establece la "flag" correspondiente de dicha selección.
    //*************************************************************************************************************************
    fun mostrarInfo_Crear(){
        flag_seleccion = 1
        text_informacion_MP.text = getString(R.string.Info_Crear)
    }
    fun mostrarInfo_Modificar(){
        flag_seleccion = 2
        text_informacion_MP.text = getString(R.string.Info_Modificar)
    }
    fun mostrarInfo_Eliminar(){
        flag_seleccion = 3
        text_informacion_MP.text = getString(R.string.Info_Eliminar)
    }
    fun mostrarInfo_Informacion(){
        flag_seleccion = 4
        text_informacion_MP.text = getString(R.string.Info_Informacion)
    }
    //*************************************************************************************************************************

    //Esta función redirecciona al usuario a la actividad correspondiente a su selección segunla bandera activada. En caso de no haber seleccionado
    //alguna de las opciones, se le indica al usuario que debe seleccionar alguna para continuar.
    //*************************************************************************************************************************
    fun continuarActividad(){
        if(flag_seleccion.equals(1)) {
            val intent = Intent(this, Programacion::class.java)
            startActivity(intent)
        }else if(flag_seleccion.equals(2)){
            val intent = Intent(this, modificacion::class.java)
            startActivity(intent)
        }else if(flag_seleccion.equals(3)){
            val intent = Intent(this, Eliminar::class.java)
            startActivity(intent)
        }else if(flag_seleccion.equals(4)){
            val intent = Intent(this, Menu_Informacion::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show()
        }
    }
    //*************************************************************************************************************************
}
