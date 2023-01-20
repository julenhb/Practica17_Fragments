package com.example.practica17_fragments.Alumno

class Alumno : java.io.Serializable {

    var nombre: String = ""
    var apellidos: String = ""
    var dni: String = ""
    var imageId: Int = 0
    var isImage = false

    constructor(){}

    constructor(nombre: String, apellidos: String, dni: String, imageId: Int) {
        this.nombre = nombre
        this.apellidos = apellidos
        this.dni = dni
        this.imageId = imageId
        this.isImage = false
    }

    constructor(nombre: String, imageId: Int) {
        this.nombre = nombre
        this.imageId = imageId
        this.isImage = true
    }

    override fun toString(): String {
        return nombre
    }
}