package com.lutec.steven.proyectodiseno_1.Modelos

class instProyecto {
    private var id: Int = 0
    private var instruccion: String = ""

    constructor(id: Int,instruccion: String) {
        this.id = id
        this.instruccion = instruccion
    }

    fun getID(): Int{
        return id;
    }
    fun getInstruccion(): String{
        return  instruccion;
    }

    override fun toString(): String {
        return instruccion
    }
}