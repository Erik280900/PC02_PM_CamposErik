package com.campos.erik.laboratoriocalificado02

data class Contacto(
    val nombre: String,
    val telefono: String,
    val email: String
)

class Agenda {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
        println("Contacto agregado: ${contacto.nombre}")
    }

    fun listarContactos() {
        if (contactos.isEmpty()) {
            println("No hay contactos registrados.")
        } else {
            println("Lista de contactos:")
            contactos.forEachIndexed { index, contacto ->
                println("${index + 1}. ${contacto.nombre} - ${contacto.telefono} - ${contacto.email}")
            }
        }
    }

    fun buscarPorNombre(nombre: String) {
        val encontrados = contactos.filter { it.nombre.contains(nombre, ignoreCase = true) }
        if (encontrados.isEmpty()) {
            println("No se encontraron contactos con el nombre \"$nombre\".")
        } else {
            println("Contactos encontrados:")
            encontrados.forEach {
                println("${it.nombre} - ${it.telefono} - ${it.email}")
            }
        }
    }
}

fun main() {
    val agenda = Agenda()
    var opcion: Int

    do {
        println("\n--- AGENDA DE CONTACTOS ---")
        println("1. Agregar contacto")
        println("2. Listar contactos")
        println("3. Buscar por nombre")
        println("4. Salir")
        print("Selecciona una opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Teléfono: ")
                val telefono = readLine() ?: ""
                print("Email: ")
                val email = readLine() ?: ""
                agenda.agregarContacto(Contacto(nombre, telefono, email))
            }
            2 -> agenda.listarContactos()
            3 -> {
                print("Nombre a buscar: ")
                val nombre = readLine() ?: ""
                agenda.buscarPorNombre(nombre)
            }
            4 -> println("¡Hasta luego!")
            else -> println("Opción no válida. Intenta de nuevo.")
        }

    } while (opcion != 4)
}
