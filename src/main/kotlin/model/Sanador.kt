package model

import kotlinx.coroutines.delay;

class Sanador(nombre: String, ataque: Int, vida: Int, val magia: Int): Personaje(nombre, ataque, vida) {
    suspend fun recuperar(objetivo:Personaje){
        println("$nombre lanza Recuperar a ${objetivo.nombre}")
        delay(500)
        objetivo.curar(magia)
    }
    suspend fun revivir(objetivo:Personaje){
        println("$nombre lanza revivir a ${objetivo.nombre}")
        objetivo.estado = Estado.Normal
        objetivo.vida=100
        println("${objetivo.nombre} vuelve a la vida con 100 puntos de vida!")
    }
}


