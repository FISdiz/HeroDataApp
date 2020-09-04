package cl.desafiolatam.herodataapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import cl.desafiolatam.herodataapp.R
import cl.desafiolatam.herodataapp.model.Repository
import cl.desafiolatam.herodataapp.model.pojo.HeroMini
import cl.desafiolatam.herodataapp.viewmodel.HeroViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("tag", "creando")

    }
}