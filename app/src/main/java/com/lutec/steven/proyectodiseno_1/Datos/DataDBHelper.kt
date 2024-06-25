package com.lutec.steven.proyectodiseno_1.Datos

import android.app.ActionBar
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.lutec.steven.proyectodiseno_1.Modelos.Usuario
import com.lutec.steven.proyectodiseno_1.Modelos.instProyecto
import com.lutec.steven.proyectodiseno_1.Modelos.saveProyecto
import com.lutec.steven.proyectodiseno_1.NombreUsuario
import java.util.concurrent.locks.Condition

class DataDBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){
    private val db: SQLiteDatabase
    private val values: ContentValues
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "APIK_DB"
    }
    init {
        db = this.writableDatabase
        values = ContentValues()
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE " +
                Tables.Usuarios.TABLE_NAME + " ("
                + Tables.Usuarios._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Tables.Usuarios.COLUMN_NAME + " TEXT NOT NULL" + ")")

        db!!.execSQL("CREATE TABLE " +
                Tables.ProyectosExistentes.TABLE_NAME + " ("
                + Tables.ProyectosExistentes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Tables.ProyectosExistentes.COLUMN_NAME + " TEXT NOT NULL" + ")")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    //---------------------------------------------------Tabla de Usuarios---------------------------------------------------//
    //*************************************************************************************************************************
    fun insertarUsuario(usuario: List<Usuario>){
        values.put(Tables.Usuarios.COLUMN_NAME,usuario[0].getName())
        db!!.insert(Tables.Usuarios.TABLE_NAME, null,values)
    }

    fun getUsuarios(): MutableList<Usuario>{
        Tables.Usuarios.usuarios.clear()
        val columnas = arrayOf(Tables.Usuarios._ID, Tables.Usuarios.COLUMN_NAME)
        val c = db.query(Tables.Usuarios.TABLE_NAME,columnas,null,null,null,null,null)
        if (c.moveToFirst()){
            do {
                Tables.Usuarios.usuarios.add(Usuario(c.getInt(0),c.getString(1)))
            }while (c.moveToNext())
        }
        return Tables.Usuarios.usuarios
    }
    //*************************************************************************************************************************

    //----------------------------------------Tabla de proyectos existentes--------------------------------------------------//
    //*************************************************************************************************************************
    fun insertarProyecto(proyecto: List<saveProyecto>){
    values.put(Tables.ProyectosExistentes.COLUMN_NAME,proyecto[0].getProyecto())
    db!!.insert(Tables.ProyectosExistentes.TABLE_NAME, null,values)
    }

    fun getProyectos(): MutableList<saveProyecto> {
        Tables.ProyectosExistentes.proyectosExistentes.clear()
        val columnas = arrayOf(Tables.ProyectosExistentes._ID, Tables.ProyectosExistentes.COLUMN_NAME)
        val c = db.query(Tables.ProyectosExistentes.TABLE_NAME,columnas,null,null,null,null,null)
        if (c.moveToFirst()){
            do {
                Tables.ProyectosExistentes.proyectosExistentes.add(saveProyecto(c.getInt(0),c.getString(1)))
            }while (c.moveToNext())
        }
        return Tables.ProyectosExistentes.proyectosExistentes
    }
    //*************************************************************************************************************************

    //---------------------------------------------Tabla de Instrucciones----------------------------------------------------//
    //*************************************************************************************************************************
    fun insertarInstruccion(proyecto: List<instProyecto>){
        values.put(Tables.InstruccionesProyecto.COLUMN_NAME,proyecto[0].getInstruccion())
        db!!.insert(Tables.InstruccionesProyecto.TABLE_NAME, null,values)
    }
    fun actualizarInstruccion(proyecto: List<instProyecto>){
        val args = arrayOf(proyecto[0].getID().toString())
        values.put(Tables.InstruccionesProyecto.COLUMN_NAME,proyecto[0].getInstruccion())
        db.update(Tables.InstruccionesProyecto.TABLE_NAME,values,Tables.InstruccionesProyecto._ID + "=?",args)
    }
    fun eliminarInstruccion(condition: String){
        val args = arrayOf(condition)
        db.delete(Tables.InstruccionesProyecto.TABLE_NAME,Tables.InstruccionesProyecto._ID + "=?",args)
    }

    fun getInstruccion(): MutableList<instProyecto> {
        Tables.InstruccionesProyecto.instruccionesProyecto.clear()
        val columnas = arrayOf(Tables.InstruccionesProyecto._ID, Tables.InstruccionesProyecto.COLUMN_NAME)
        val c = db.query(Tables.InstruccionesProyecto.TABLE_NAME,columnas,null,null,null,null,null)
        if (c.moveToFirst()){
            do {
                Tables.InstruccionesProyecto.instruccionesProyecto.add(instProyecto(c.getInt(0),c.getString(1)))
            }while (c.moveToNext())
        }
        return Tables.InstruccionesProyecto.instruccionesProyecto
    }

    //-------------------------------------------Opciones Tabla de instrucciones---------------------------------------------//
    fun eliminarTablaInstrucciones(){
            db!!.execSQL("DROP TABLE "+Tables.InstruccionesProyecto.TABLE_NAME)
            //db!!.rawQuery("DROP TABLE IF EXIST"+Tables.InstruccionesProyecto.TABLE_NAME,null)
        }
    fun crearTablaInstrucciones(){
        db!!.execSQL("CREATE TABLE " +
                Tables.InstruccionesProyecto.TABLE_NAME + " ("
                + Tables.InstruccionesProyecto._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Tables.InstruccionesProyecto.COLUMN_NAME + " TEXT NOT NULL" + ")")
        /*db!!.rawQuery("CREATE TABLE " +
                Tables.InstruccionesProyecto.TABLE_NAME + " ("
                + Tables.InstruccionesProyecto._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Tables.InstruccionesProyecto.COLUMN_NAME + " TEXT NOT NULL" + ")",null)*/
    }
    fun verificarTablaInstrucciones():Boolean{
        try{
            Tables.InstruccionesProyecto.instruccionesProyecto.clear()
            val columnas = arrayOf(Tables.InstruccionesProyecto._ID, Tables.InstruccionesProyecto.COLUMN_NAME)
            val c = db.query(Tables.InstruccionesProyecto.TABLE_NAME,columnas,null,null,null,null,null)
            return true
        }catch (e: Exception){
            return false
        }

    }
    //*************************************************************************************************************************
}