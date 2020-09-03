package cl.desafiolatam.herodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import cl.desafiolatam.herodataapp.model.pojo.Hero
import cl.desafiolatam.herodataapp.model.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var heroList = ArrayList<Hero>()
    private lateinit var adapter : HeroAdapter
    private var repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroAdapter(heroList)
        heroRecycler.adapter = adapter

        repository.loadApiData()
        repository.listHero.observe(this, Observer { adapter.updateItems(it) })
    }
}