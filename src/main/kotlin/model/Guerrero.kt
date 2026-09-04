package model

import kotlinx.coroutines.delay;

class Guerrero(nombre: String, ataque: Int, vida: Int): Personaje(nombre, ataque, vida){
    suspend fun golpeJusticiero(objetivo: Personaje){
        println("$nombre lanza Golpe Justiciero")
        delay (1000)
        objetivo.recibirDano(ataque)

    }
}

