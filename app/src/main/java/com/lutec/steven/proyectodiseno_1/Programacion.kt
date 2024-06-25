package com.lutec.steven.proyectodiseno_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.lutec.steven.proyectodiseno_1.Modelos.instProyecto
import com.lutec.steven.proyectodiseno_1.Datos.DataDBHelper
import kotlinx.android.synthetic.main.activity_programacion.*

class Programacion : AppCompatActivity() {

    private var listaInstrucciones: MutableList<instProyecto> = ArrayList()
    private var db: DataDBHelper? = null
    private var idDato = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programacion)

        db = DataDBHelper(this)

        //Debemos verificar la existencia de la tabla para la creación de programas. En caso de que exista, se procede a eliminarla y crearla
        //inmediatamente; caso contrario en caso de que no exista procedemos a crearla.
        //*************************************************************************************************************************
        if (db!!.verificarTablaInstrucciones()){
            db!!.eliminarTablaInstrucciones()
            db!!.crearTablaInstrucciones()
        }else{
            db!!.crearTablaInstrucciones()
        }
        //*************************************************************************************************************************

        //Las siguientes funciones establecen las relaciones entre los archivos "inst_Entorno.xml" y "inst_Logicas" y los listview correspondiente.
        //Con esto en caso de agregar, modificar o eliminar una instrucción, unicamente cambiar la información en dichos archivos.
        //*************************************************************************************************************************
        listView_InstEntorno.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.inst_Entorno))
        listView_InstLogica.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.inst_Logicas))
        //*************************************************************************************************************************

        //Se establecen las relaciones entre las selecciones de las listview y la GUI
        //*************************************************************************************************************************
        listView_InstEntorno.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val instruccionSeleccionada = parent.getItemAtPosition(position) as String
            val infoInstSeleccionada = resources.getStringArray(R.array.info_inst_Entorno).get(position)
            textView_InfoInstruccion!!.setText(infoInstSeleccionada)
            editText_Instruccion!!.setText(instruccionSeleccionada)}
        listView_InstLogica.onItemClickListener = AdapterView.OnItemClickListener{ parent,view,position, id ->
            val instruccionSeleccionada = parent.getItemAtPosition(position) as String
            val infoInstSeleccionada = resources.getStringArray(R.array.info_inst_Logicas).get(position)
            textView_InfoInstruccion!!.setText(infoInstSeleccionada)
            editText_Instruccion!!.setText(instruccionSeleccionada) }
        Lista_Programa.onItemClickListener = AdapterView.OnItemClickListener{ parent,view,position, id ->
            val instruccionSeleccionada = parent.getItemAtPosition(position)
            idDato = position
            editText_Instruccion!!.setText(instruccionSeleccionada.toString())
            textView_InfoInstruccion!!.setText("")}
        //*************************************************************************************************************************


        btn_AgregarInst_Prog.setOnClickListener {
            AgregarNuevaInstruccion()
            //verInstrucciones(db!!.getInstruccion())
            }
        btn_ModifInst_Prog.setOnClickListener{
            ActualizarInstruccion(idDato)
            //verInstrucciones(db!!.getInstruccion())
        }
        btn_ElimInst_Prog.setOnClickListener{
            EliminarInstruccion(idDato)
            //verInstrucciones(db!!.getInstruccion())
        }

        btn_Regresar_Prog.setOnClickListener{
            //db!!.eliminarTablaInstrucciones()
            volverMenuPrincipal()
        }
        btn_Continuar_Prog.setOnClickListener{continuarNombrePrograma()}
    }

    fun volverMenuPrincipal(){
        onBackPressed()
    }
    fun continuarNombrePrograma(){
        val intent = Intent(this, NombreProyecto::class.java)
        startActivity(intent)
    }

    //Las siguientes funciones se utilizan para las acciones de agregar, modificar o eliminar una instrucción del programa que estamos creando
    //Cuando la acción es eliminar, debemos consultar dicha acción.
    //*************************************************************************************************************************
    fun AgregarNuevaInstruccion(){
        listaInstrucciones.add(instProyecto(0,editText_Instruccion.text.toString()))
        db!!.insertarInstruccion(listaInstrucciones)
        verInstrucciones(db!!.getInstruccion())
        listaInstrucciones.clear()
    }
    fun ActualizarInstruccion(id: Int){
        listaInstrucciones.add(instProyecto(id,editText_Instruccion.text.toString()))
        db!!.actualizarInstruccion(listaInstrucciones)
        verInstrucciones(db!!.getInstruccion())
        listaInstrucciones.clear()
    }
    fun EliminarInstruccion(id: Int){
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.mipmap.ic_launcher_round)
                .setTitle(R.string.eliminar_registro)
                .setPositiveButton("Eliminar"){dialog,which ->
                    db!!.eliminarInstruccion(db!!.getInstruccion().get(id).getID().toString())
                    verInstrucciones(db!!.getInstruccion())
                }
                .setNegativeButton("Cancelar"){dialog, which -> }
                .show()
    }
    //*************************************************************************************************************************

    private fun verInstrucciones(listData: MutableList<instProyecto>){
        val adapter = ArrayAdapter<instProyecto>(this, android.R.layout.simple_list_item_1,listData)
        Lista_Programa!!.adapter = adapter
    }
}
