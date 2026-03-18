package mx.edu.itesca.practica6

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class tipo_orden : AppCompatActivity() {


    private val listaClientes = Carrito.clientes

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_orden)

        val radioGroup: RadioGroup = findViewById(R.id.radioOrderType)
        val radioPerson: RadioButton = findViewById(R.id.radioPerson)
        val spinner: Spinner = findViewById(R.id.spinnerPerson)
        val etNombre: EditText = findViewById(R.id.etNombrePersona)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)
        val btnConsultar: Button = findViewById(R.id.btnConsultar)
        val tvResultado: TextView = findViewById(R.id.tvResultado)

        val productoNombre = intent.getStringExtra("name") ?: "Producto"
        val precio = intent.getDoubleExtra("precio", 0.0)
        val cantidad = intent.getIntExtra("cantidad", 1)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaClientes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.isEnabled = false
        etNombre.isEnabled = false

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radioPerson) {
                spinner.isEnabled = true
                etNombre.isEnabled = true
            } else {
                spinner.isEnabled = false
                etNombre.isEnabled = false
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val seleccionado = listaClientes[position]
                etNombre.setText(seleccionado)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnGuardar.setOnClickListener {

            val pedido = Pedido(productoNombre, precio, cantidad)

            if (radioGroup.checkedRadioButtonId == R.id.radioTable) {

                Carrito.agregarPedidoMesa(pedido)

                tvResultado.text = "Producto agregado a la orden de la mesa"
                return@setOnClickListener
            }

            if (!radioPerson.isChecked) {
                tvResultado.text = "Selecciona un tipo de orden"
                return@setOnClickListener
            }

            val nombreCliente = etNombre.text.toString()

            if (nombreCliente.isEmpty()) {
                tvResultado.text = "Ingresa un nombre"
                return@setOnClickListener
            }

            Carrito.agregarCliente(nombreCliente)
            adapter.notifyDataSetChanged()

            Carrito.agregarPedido(nombreCliente, pedido)

            tvResultado.text = "Producto agregado al carrito de $nombreCliente"
        }
        btnConsultar.setOnClickListener {

            var texto = ""
            var total = 0.0

            if (radioGroup.checkedRadioButtonId == R.id.radioTable) {

                val lista = Carrito.obtenerPedidos("MESA")

                if (lista.isNullOrEmpty()) {
                    tvResultado.text = "No hay pedidos para la mesa"
                    return@setOnClickListener
                }

                texto = "PEDIDO DE MESA\n\n"

                for (p in lista) {
                    val subtotal = p.precio * p.cantidad
                    total += subtotal

                    texto += "${p.nombre} x${p.cantidad} - $${String.format("%.2f", subtotal)}\n"
                }

                texto += "\nTOTAL: $${String.format("%.2f", total)}"

                tvResultado.text = texto
                return@setOnClickListener
            }

            val nombreCliente = etNombre.text.toString()

            val lista = Carrito.obtenerPedidos(nombreCliente)

            if (lista.isNullOrEmpty()) {
                tvResultado.text = "No hay pedidos para este cliente"
                return@setOnClickListener
            }

            texto = "Cliente: $nombreCliente\n\n"

            for (p in lista) {
                val subtotal = p.precio * p.cantidad
                total += subtotal

                texto += "${p.nombre} x${p.cantidad} - $${String.format("%.2f", subtotal)}\n"
            }

            texto += "\nTOTAL: $${String.format("%.2f", total)}"

            tvResultado.text = texto
        }
    }
}