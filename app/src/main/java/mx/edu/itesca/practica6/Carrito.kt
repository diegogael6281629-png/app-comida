package mx.edu.itesca.practica6

object Carrito {

    val pedidosPorCliente = HashMap<String, MutableList<Pedido>>()

    // ✅ NUEVO
    val clientes = mutableListOf<String>()

    fun agregarCliente(nombre: String) {
        if (!clientes.contains(nombre)) {
            clientes.add(nombre)
        }
    }

    fun agregarPedido(cliente: String, producto: Pedido) {

        val lista = pedidosPorCliente.getOrPut(cliente) { mutableListOf() }

        val existente = lista.find { it.nombre == producto.nombre }

        if (existente != null) {
            existente.cantidad += producto.cantidad
        } else {
            lista.add(producto)
        }
    }
    fun agregarPedidoMesa(producto: Pedido) {

        val lista = pedidosPorCliente.getOrPut("MESA") { mutableListOf() }

        val existente = lista.find { it.nombre == producto.nombre }

        if (existente != null) {
            existente.cantidad += producto.cantidad
        } else {
            lista.add(producto)
        }
    }

    fun obtenerPedidos(cliente: String): MutableList<Pedido>? {
        return pedidosPorCliente[cliente]
    }
}