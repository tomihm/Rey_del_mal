package model

sealed class Estado {
    object Normal: Estado()
    object Muerto: Estado()
    object Envenenado: Estado()
}