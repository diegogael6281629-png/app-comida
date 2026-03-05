package mx.edu.itesca.practica6


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {

    companion object {
        // 🔥 Asientos guardados por película
        val movieSeats = mutableMapOf<String, MutableSet<Int>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        val confirm: Button = findViewById(R.id.confirm)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        val bundle = intent.extras
        val movieName = bundle?.getString("name") ?: "default"

        title.text = movieName

        // 🔥 Si la película no existe en el mapa, la creamos
        if (!movieSeats.containsKey(movieName)) {
            movieSeats[movieName] = mutableSetOf()
        }

        val groups = listOf(row1, row2, row3, row4)

        for (group in groups) {
            for (i in 0 until group.childCount) {

                val radio = group.getChildAt(i) as RadioButton

                radio.setOnClickListener {

                    // Limpiar TODOS los grupos primero
                    for (otherGroup in groups) {
                        otherGroup.clearCheck()
                    }

                    // Marcar solo el que se clickeó
                    radio.isChecked = true
                }
            }
        }

        // 🔥 Deshabilitar asientos ya comprados SOLO de esa película
        for (group in groups) {
            for (i in 0 until group.childCount) {
                val radio = group.getChildAt(i) as RadioButton
                val seatNumber = radio.text.toString().toInt()

                if (movieSeats[movieName]!!.contains(seatNumber)) {
                    radio.isEnabled = false
                    radio.setBackgroundResource(R.drawable.radio_disabled)
                }
            }
        }

        // 🔥 Botón Confirm
        confirm.setOnClickListener {

            var selectedSeatNumber: Int? = null

            for (group in groups) {
                if (group.checkedRadioButtonId != -1) {
                    val selectedRadio = findViewById<RadioButton>(group.checkedRadioButtonId)
                    selectedSeatNumber = selectedRadio.text.toString().toInt()
                }
            }

            if (selectedSeatNumber != null) {

                // 🔥 Guardar asiento comprado en la película correcta
                movieSeats[movieName]!!.add(selectedSeatNumber)

                val resultIntent = Intent()
                resultIntent.putExtra("seatBought", 1)
                setResult(RESULT_OK, resultIntent)

                finish()

            } else {
                Toast.makeText(this, "Select a seat first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}