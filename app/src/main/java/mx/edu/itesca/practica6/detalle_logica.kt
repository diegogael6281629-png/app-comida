package mx.edu.itesca.practica6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class detalle_logica : AppCompatActivity() {

    private lateinit var Name: String
    private var precioBase: Double = 0.0
    private var cantidad: Int = 1

    private val seatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        val iv_producto_image: ImageView = findViewById(R.id.iv_platillo_imagen)
        val tv_nombre_producto: TextView = findViewById(R.id.tv_nombre_platillo)
        val tv_producto_desc: TextView = findViewById(R.id.tv_platillo_desc)
        val tv_producto_precio: TextView = findViewById(R.id.tv_precio)

        val btnMenos: Button = findViewById(R.id.btnMenos)
        val btnMas: Button = findViewById(R.id.btnMas)
        val tvCantidad: TextView = findViewById(R.id.tvCantidad)

        val Control_consumo: Button = findViewById(R.id.botonP)

        val bundle = intent.extras

        if (bundle != null) {

            iv_producto_image.setImageResource(bundle.getInt("imagen"))

            Name = bundle.getString("nombre") ?: "default"
            tv_nombre_producto.text = Name

            tv_producto_desc.text = bundle.getString("descripcion")

            precioBase = bundle.getDouble("precio", 0.0)

        } else {
            Name = "default"
        }

        actualizarVista(tvCantidad, tv_producto_precio)

        // ➖
        btnMenos.setOnClickListener {
            if (cantidad > 1) {
                cantidad--
                actualizarVista(tvCantidad, tv_producto_precio)
            }
        }

        // ➕
        btnMas.setOnClickListener {
            cantidad++
            actualizarVista(tvCantidad, tv_producto_precio)
        }

        Control_consumo.setOnClickListener {

            val intent = Intent(this, tipo_orden::class.java)

            intent.putExtra("name", Name)
            intent.putExtra("precio", precioBase)
            intent.putExtra("cantidad", cantidad)

            seatLauncher.launch(intent)
        }
    }

    private fun actualizarVista(tvCantidad: TextView, tvPrecio: TextView) {
        tvCantidad.text = cantidad.toString()
        val total = precioBase * cantidad
        tvPrecio.text = "$${String.format("%.2f", total)}"
    }
}