package mx.edu.itesca.practica6


import android.content.Intent
import android.media.AudioMetadata
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.Key


class detalle_pelicula : AppCompatActivity() {

    private val totalSeats = 20
    private lateinit var movieName: String

    // ✅ Launcher
    private val seatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == RESULT_OK) {
            updateAvailableSeats()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)
        val buyTickets: Button = findViewById(R.id.botonP)

        val bundle = intent.extras
        if (bundle != null) {
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            movieName = bundle.getString("titulo") ?: "default"
            tv_nombre_pelicula.text = movieName
            tv_pelicula_desc.text = bundle.getString("sinopsis")
        } else {
            movieName = "default"
        }

        updateAvailableSeats()

        buyTickets.setOnClickListener {

            val intent = Intent(this, SeatSelection::class.java)
            intent.putExtra("name", movieName)

            seatLauncher.launch(intent)
        }
    }

    // 🔥 Función que calcula asientos dinámicamente
    private fun updateAvailableSeats() {

        val seatLeft: TextView = findViewById(R.id.seatleft)

        val soldSeats = SeatSelection.movieSeats[movieName]?.size ?: 0
        val availableSeats = totalSeats - soldSeats

        seatLeft.text = "$availableSeats seats available"
    }
}