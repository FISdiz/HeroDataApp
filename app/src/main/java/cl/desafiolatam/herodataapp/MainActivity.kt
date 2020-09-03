package cl.desafiolatam.herodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import cl.desafiolatam.herodataapp.model.pojo.Hero
import cl.desafiolatam.herodataapp.model.Repository
import cl.desafiolatam.herodataapp.model.pojo.HeroMini
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var heroList = ArrayList<HeroMini>()
    private lateinit var adapter : HeroAdapter
    private lateinit var repository : Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroAdapter(heroList)
        heroRecycler.adapter = adapter
        repository = Repository(applicationContext)

        repository.loadApiData()
        repository.listHero.observe(this, Observer {
            Log.d("TAG","$it")
            adapter.updateItems(it)
        })

    }
}