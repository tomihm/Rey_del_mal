package model

import kotlinx.coroutines.delay;

class Mago (nombre: String, ataque: Int, vida: Int, val magia: Int) : Personaje(nombre, ataque, vida) {
    suspend fun relampago (objetivo: Personaje){
        println("$nombre lanza Relampago a {$objetivo.nombre}")
        delay(3000)
        objetivo.recibirDano(magia)
    }
    suspend fun ventisca (objetivo: Personaje){
        println("$nombre lanza Ventisca a {$objetivo.nombre}")
        delay(5000)
        objetivo.recibirDano(magia*2)
    }
}

