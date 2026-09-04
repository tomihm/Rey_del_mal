import kotlinx.coroutines.*
import model.*

fun main() = runBlocking {

    val aurora    = Sanador("Aurora", 8, 150, 180)
    val rex       = Guerrero("Rex", 32, 350)
    val vincent   = Mago("Vincent", 10, 160, 200)
    val reyDelMal = Monstruo("Rey del Mal", 185, 780, 180)

    val grupo = listOf(vincent, aurora, rex)

    println("=== COMIENZA LA BATALLA ===")

    launch { vincent.accion(reyDelMal, vincent::relampago) }
    launch { reyDelMal.accion(vincent, reyDelMal::golpeMalvado) }
    launch { reyDelMal.accion(rex, reyDelMal::veneno) }
    launch { rex.accion(reyDelMal, rex::golpeJusticiero) }
    launch { aurora.accion(vincent, aurora::recuperar) }
    launch { reyDelMal.accion(aurora, reyDelMal::golpeMalvado) }
    launch { vincent.accion(reyDelMal, vincent::relampago) }
    launch { rex.accion(reyDelMal, rex::golpeJusticiero) }

    delay(8000)   // esperamos a que terminen todos los casteos

    println("=== FIN DE LA BATALLA ===")

    var enPie = 0
    for (heroe in grupo) {
        if (heroe.vida >= 0) enPie++
    }
    println("Héroes en pie: $enPie")
}