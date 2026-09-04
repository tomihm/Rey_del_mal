package model

import kotlinx.coroutines.delay


class Monstruo(nombre: String, ataque: Int, vida: Int, val magia: Int) : Personaje(nombre, ataque, vida) {
    suspend fun golpeMalvado(objetivo: Personaje) {
        println("$nombre lanza Golpe Malvado a ${objetivo.nombre}")
        delay(1500)
        objetivo.recibirDano(ataque)
    }

    suspend fun veneno(objetivo: Personaje) {
        println("$nombre lanza Veneno a ${objetivo.nombre}")
        delay(2000)
        objetivo.recibirDano(magia)

        if (objetivo.estado !is Estado.Muerto) {
            objetivo.estado = Estado.Envenenado
            println("${objetivo.nombre} queda envenenado.")
        }
    }
}