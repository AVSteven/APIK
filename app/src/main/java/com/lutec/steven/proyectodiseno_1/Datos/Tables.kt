package com.lutec.steven.proyectodiseno_1.Datos

import com.lutec.steven.proyectodiseno_1.Modelos.Usuario
import com.lutec.steven.proyectodiseno_1.Modelos.instProyecto
import com.lutec.steven.proyectodiseno_1.Modelos.saveProyecto


    //Clase para la creación de las tablas principales de la base de datos.
class Tables {
    abstract class Usuarios{
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "usuarios"
            val COLUMN_NAME = "nombre"
            var usuarios: MutableList<Usuario> = ArrayList()
        }
    }
    abstract class ProyectosExistentes{
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "proyectos_guardados"
            val COLUMN_NAME = "nombre_proyecto"
            var proyectosExistentes: MutableList<saveProyecto> = ArrayList()
        }
    }
    abstract class InstruccionesProyecto{
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "instrucciones_proyecto"
            val COLUMN_NAME = "instrucciones"
            var instruccionesProyecto: MutableList<instProyecto> = ArrayList()
        }
    }
}