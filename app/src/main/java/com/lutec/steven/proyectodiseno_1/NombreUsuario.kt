package com.lutec.steven.proyectodiseno_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.ArrayAdapter
import com.lutec.steven.proyectodiseno_1.Datos.DataDBHelper
import com.lutec.steven.proyectodiseno_1.Modelos.Usuario
import kotlinx.android.synthetic.main.activity_nombre_usuario.*

class NombreUsuario : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var listaUsuarios: MutableList<Usuario> = ArrayList()
    private var db: DataDBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre_usuario)
        List_Usuarios!!.onItemClickListener = this
        db = DataDBHelper(this)
        verUsuarios(db!!.getUsuarios())
        btn_continuar_nu.setOnClickListener{verificarDatos()}
    }

    //La siguiente función nos permite unir la lista generada por la tabla de usuarios y mostrarla en el listview de la GUI
    //*************************************************************************************************************************
    private fun verUsuarios(listData: MutableList<Usuario>){
        val adapter = ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,listData)
        List_Usuarios!!.adapter = adapter
    }
    //*************************************************************************************************************************

    //La siguiente función nos permite determinar el elemento que ha sido seleccionado en la listview
    //*************************************************************************************************************************
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3:Long) {
        //EditText_NuevoUsuario!!.setText(db!!.getUsuarios().get(p2).getName())
        val intent = Intent(this, MenuPrincipal::class.java)
        intent.putExtra("name",db!!.getUsuarios().get(p2).getName())
        startActivity(intent)
    }
    //*************************************************************************************************************************

    //Esta función nos permite determinar si el espacio de usuario esta vacio. En caso de ser asi le indica al usuario que debe ingresar
    // un nombre. Una vez ingresado procede a almacenarlo en la base de datos y posteriormente tranferirnos a la siguiente actividad
    //*************************************************************************************************************************
    fun verificarDatos(){
        if(EditText_NuevoUsuario.text.toString().isEmpty()) {
            Toast.makeText(this, "El Usuario no puede estar vacio", Toast.LENGTH_SHORT).show()
        }else{
            listaUsuarios.add(Usuario(0,EditText_NuevoUsuario.text.toString()))
            db!!.insertarUsuario(listaUsuarios)
            listaUsuarios.clear()
            val intent = Intent(this, MenuPrincipal::class.java)
            intent.putExtra("name",EditText_NuevoUsuario.text.toString())
            startActivity(intent)
        }
    }
    //*************************************************************************************************************************
}

