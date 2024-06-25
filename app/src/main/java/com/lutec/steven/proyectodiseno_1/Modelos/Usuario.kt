package com.lutec.steven.proyectodiseno_1.Modelos

class Usuario {
    private var id: Int = 0
    private var name: String = ""

    constructor(id: Int,name: String) {
        this.id = id
        this.name = name
    }

    fun getID(): Int{
        return id;
    }
    fun getName(): String{
        return  name;
    }

    override fun toString(): String {
        return name
    }

}