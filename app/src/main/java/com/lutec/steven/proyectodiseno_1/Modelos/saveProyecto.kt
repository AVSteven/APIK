package com.lutec.steven.proyectodiseno_1.Modelos

class saveProyecto {
    private var id: Int = 0
    private var nombreProyecto: String = ""

    constructor(id: Int,nombreProyecto: String) {
        this.id = id
        this.nombreProyecto = nombreProyecto
    }

    fun getID(): Int{
        return id;
    }
    fun getProyecto(): String{
        return  nombreProyecto;
    }

    override fun toString(): String {
        return nombreProyecto
    }
}