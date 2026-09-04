package model

open class Personaje(
    val nombre:String,
    val ataque: Int,
    var vida: Int,
    var estado: Estado = Estado.Normal
    ){
    suspend fun accion(objetivo: Personaje, hechizo: suspend (Personaje) -> Unit){
        if (estado is Estado.Muerto){
            println("$nombre esta muerto y no puede actuar")
            return
        }
        hechizo(objetivo)
    }
    fun recibirDano(cantidad: Int){
        vida -= cantidad
        println("$nombre recibe $cantidad puntos de daño, le quedan $vida puntos de vida")

        if (vida <= 0 && estado !is Estado.Muerto){
            estado = Estado.Muerto
            println("$nombre ha muerto")
        }
    }

    fun curar (cantidad:Int){
        vida += cantidad
        println("$nombre recupera $cantidad puntos de vida")
    }
}

