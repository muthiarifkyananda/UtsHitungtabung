package muthiaraa.utshitungbalok


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import muthiaraa.utshitungbalok.databinding.ActivityMainBinding

import kotlin.math.PI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            // Mengambil input radius dan tinggi dari EditText
            val radius = binding.etRadius.text.toString().toDoubleOrNull()
            val tinggi = binding.etTinggi.text.toString().toDoubleOrNull()

            // Validasi input tidak kosong atau bukan angka
            if (radius == null || tinggi == null) {
                Toast.makeText(this, "Masukkan nilai yang valid!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung volume dan luas permukaan tabung
                val volume = PI * radius * radius * tinggi
                val luasPermukaan = 2 * PI * radius * (radius + tinggi)

                // Tampilkan hasil ke TextView
                binding.tvHasil.text =
                    "Volume: %.2f cm³\nLuas Permukaan: %.2f cm²".format(volume, luasPermukaan)
            }
        }
    }

}