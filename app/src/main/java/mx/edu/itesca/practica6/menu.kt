package mx.edu.itesca.practica6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class menu : AppCompatActivity() {
    var Comidaadapter: ProductoApadter? = null
    var BebidasAdapter: ProductoApadter? = null
    var Comidas = ArrayList<Producto>()
    var Bebidas = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        cargarComidas()
        cargarBebidas()

        Comidaadapter = ProductoApadter(context = this, Comidas)
        BebidasAdapter = ProductoApadter(context = this, Bebidas)
        val gridComidas: GridView = findViewById(R.id.comidas_menu)
        val gridBebidas: GridView = findViewById(R.id.bebidas_menu)

        gridComidas.adapter = Comidaadapter
        gridBebidas.adapter = BebidasAdapter
    }
    fun cargarComidas() {

        Comidas.add(
            Producto(
                "Hamburguesa Sencilla",
                R.drawable.hamburguesa,
                         R.drawable.hamburguesa,
                235.00,
                "Deliciosa carne de res acompañada de lechuga, tomate y cebolla, servido en pan brioche. Incluye papas!",
                0
            )
        )

        Comidas.add(
            Producto(
                "Hamburguesa Queso-Tocino",
                R.drawable.cheeseburger,
                R.drawable.cheeseburger,
                285.00,
                "Jugosa carne de res, acompañada de lechuga, tomate, cebolla, queso americano y delicioso tocino ahumado, servido en pan brioche. Incluye papas!",
                0
            )
        )

        Comidas.add(
            Producto(
                "Ensalada de Res",
                R.drawable.ensaladares,
                R.drawable.ensaladares,
                225.00,
                "Carne de hamburguesa de res en una cama de lechuga, cebolla y tomate, acompañada de aderezo.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Chicken Tenders",
                R.drawable.chikentenders,
                R.drawable.chikentenders,
                245.00,
                "Jugosos chicken tenders acompañados de papas a la francesa, aderezo ranch y la salsa de tu elección.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Hamburguesa Queso",
                R.drawable.hamburguesaqueso,
                R.drawable.hamburguesaqueso,
                255.00,
                "Deliciosa carne de res acompañada de lechuga, tomate, cebolla y queso americano, servido en pan brioche. Incluye papas!",
                0
            )
        )

        Comidas.add(
            Producto(
                "Chicken Tender Sandwich",
                R.drawable.chikentendersandwich,
                R.drawable.chikentendersandwich,
                245.00,
                "Jugosos chicken tenders acompañados de lechuga, tomate y cebolla dentro de pan brioche. Incluye papas!",
                0
            )
        )

        Comidas.add(
            Producto(
                "Hamburguesa Tocino",
                R.drawable.hamburguesatocino,
                R.drawable.hamburguesatocino,
                265.00,
                "Carne de res acompañada de lechuga, tomate, cebolla y delicioso tocino ahumado, servido en pan brioche.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Ensalada de Pollo",
                R.drawable.ensaladatender,
                R.drawable.ensaladatender,
                225.00,
                "Chicken tenders en una cama de lechuga, cebolla y tomate, acompañada de aderezo.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Grilled Cheese",
                R.drawable.grilledcheese,
                R.drawable.grilledcheese,
                150.00,
                "El clásico platillo americano. Pan brioche relleno de queso americano y queso suizo, acompañado de papas a la francesa.",
                0
            )
        )
        Comidas.add(
            Producto("Hot Dog",
                R.drawable.dogo,
                R.drawable.dogo,
                150.00,
                "Hot Dog Clasico en un pan brioche o una salchicha de res.",
                0)
        )
        Comidas.add(
            Producto(
                "Orden de Papas a la Francesa",
                R.drawable.papas,
                R.drawable.papas,
                110.00,
                "Porción de papas a la francesa para acompañar tus platillos.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Orden de Aros de Cebolla",
                R.drawable.aroscebolla,
                R.drawable.aroscebolla,
                125.00,
                "Aros de cebolla crujientes acompañados de aderezo.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Orden de Papas Camote",
                R.drawable.camote,
                R.drawable.camote,
                150.00,
                "Porción de papas de camote, ideal para acompañar tu comida.",
                0
            )
        )

        Comidas.add(
            Producto(
                "Poutine",
                R.drawable.poutine,
                R.drawable.poutine,
                160.00,
                "Directo de Quebec. Cama de papas a la francesa y queso mozzarella bañadas en gravy de res.",
                0
            )
        )
    }

    fun cargarBebidas() {

        // 🥤 REFRESCOS
        Bebidas.add(
            Producto("Coca-cola 600 ml", R.drawable.coca, R.drawable.coca, 50.00,
                "Refresco de 600 ml bien frío.", 0)
        )

        Bebidas.add(
            Producto("Mountain Dew Original", R.drawable.mointan, R.drawable.mointan, 60.00,
                "Refresco Mountain Dew original.", 0)
        )

        Bebidas.add(
            Producto("Té Arizona", R.drawable.arizona, R.drawable.arizona, 55.00,
                "Bebida Arizona refrescante.", 0)
        )

        Bebidas.add(
            Producto("Root Beer", R.drawable.rootbe, R.drawable.rootbe, 60.00,
                "Refresco Root Beer clásico.", 0)
        )

        Bebidas.add(
            Producto("Agua mineral Topochico", R.drawable.topo, R.drawable.topo, 45.00,
                "Agua mineral Topochico.", 0)
        )

        Bebidas.add(
            Producto("Agua natural 500 ml", R.drawable.agua, R.drawable.agua, 25.00,
                "Botella de agua natural.", 0)
        )

        Bebidas.add(
            Producto("Pepsi 600 ml", R.drawable.pepsi, R.drawable.pepsi, 40.00,
                "Refresco Pepsi de 600 ml.", 0)
        )

        // 🥤 MALTEADAS
        Bebidas.add(
            Producto("Malteada de Oreo", R.drawable.malteadaoreo, R.drawable.malteadaoreo, 145.00,
                "Deliciosa malteada cremosa con galleta Oreo.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Vainilla", R.drawable.malteadavainilla, R.drawable.malteadavainilla, 145.00,
                "Deliciosa malteada de vainilla, cremosa y bien fría.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Reese's", R.drawable.malteadareeses, R.drawable.malteadareeses, 145.00,
                "Deliciosa malteada cremosa con sabor Reese's.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Chocolate", R.drawable.malteadachocolate, R.drawable.malteadachocolate, 145.00,
                "Deliciosa malteada de chocolate, cremosa y fría.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Fresa", R.drawable.malteadafresa, R.drawable.malteadafresa, 145.00,
                "Deliciosa malteada de fresa.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Nutella", R.drawable.malteadanutella, R.drawable.malteadanutella, 145.00,
                "Deliciosa malteada de Nutella, cremosa.", 0)
        )

        Bebidas.add(
            Producto("Malteada de Peanut Butter", R.drawable.malteadapb, R.drawable.malteadapb, 145.00,
                "Malteada de crema de cacahuate, suave y cremosa.", 0)
        )

        Bebidas.add(
            Producto("Malteada Lotus Biscoff", R.drawable.malteadalotus, R.drawable.malteadalotus, 200.00,
                "Deliciosa malteada cremosa con galleta Lotus Biscoff.", 0)
        )
    }

}
class ProductoApadter : BaseAdapter {
    var lista = ArrayList<Producto>()
    var context: Context? = null

    constructor(context: Context, lista: ArrayList<Producto>) : super() {
        this.lista = lista
        this.context = context
    }

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val articulo = lista[position]
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflator.inflate(R.layout.producto, null)
        val image: ImageView = vista.findViewById(R.id.iv_platillo_imagen)
        val title: TextView = vista.findViewById(R.id.tv_nombre_platillo)
        image.setImageResource(articulo.image)
        title.text = articulo.nombre
        image.setOnClickListener {
            val intento = Intent(context, detalle_logica::class.java)
            intento.putExtra("nombre", articulo.nombre)
            intento.putExtra("imagen", articulo.image)
            intento.putExtra("imagen2",articulo.image2)
            intento.putExtra("precio", articulo.precio)
            intento.putExtra("descripcion", articulo.descripcion)

            context!!.startActivity(intento)
        }
        return vista
    }
}