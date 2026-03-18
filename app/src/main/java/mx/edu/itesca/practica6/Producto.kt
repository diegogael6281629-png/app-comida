package mx.edu.itesca.practica6

data class Producto(
    var nombre: String,
    var image: Int,
    var image2: Int,
    var precio: Double,
    var descripcion: String,
    var cantidad: Int = 0
)
