package com.daniela.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.daniela.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var running = false
    var pause: Long = 0
    var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.start.setOnClickListener()
        {
            StartChronometer()
        }
        binding.pause.setOnClickListener()
        {
            PauseChronometer()
        }

        binding.reset.setOnClickListener()
        {
            ResetChronometer()
        }
    }
    private fun StartChronometer()
    {
        if(!running)
        {

                binding.chronometer.base = SystemClock.elapsedRealtime()- pause//pega o tempo real de corrida do cronômetro
                binding.chronometer.start()//inicia o cronômetro
                running = true;


        }

    }
    private fun PauseChronometer()
    {

        if(running)
        {
            binding.chronometer.stop()
            pause = SystemClock.elapsedRealtime() - binding.chronometer.base
            running = false
        }



    }
    private fun ResetChronometer()
    {
            binding.chronometer.base = SystemClock.elapsedRealtime()//pega o estado atual do cronômetro
            pause = 0



    }
}