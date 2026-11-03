
package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disasterapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(
                this@MainActivity,
                "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT
            ).show()
        }

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(
                "Tsunami",
                "Natural",
                R.drawable.tsunami
            ),
            Disaster(
                "Volcanic Eruption",
                "Natural",
                R.drawable.volcanic_eruption
            ),
            Disaster(
                "Earthquake",
                "Natural",
                R.drawable.earthquake
            ),
            Disaster(
                "Flood",
                "Natural",
                R.drawable.flood
            ),
            Disaster(
                "Fire",
                "Natural",
                R.drawable.fire
            ),
            Disaster(
                "Nuclear Accident",
                "Man-made",
                R.drawable.nuclear_accident
            ),
            Disaster(
                "Terrorist Attack",
                "Man-made",
                R.drawable.terrorist_attack
            ),
            Disaster(
                "War",
                "Man-made",
                R.drawable.war
            )
        )
    }
}
