package cl.desafiolatam.herodataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cl.desafiolatam.herodataapp.model.Hero
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var heroList = ArrayList<Hero>()
    private lateinit var adapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroAdapter(heroList)
        heroRecycler.adapter = adapter

        loadApiData()
    }

    private fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().allHeroes()

        call.enqueue(object : Callback<List<Hero>> {
            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.d("Adapter", "Error al cargar heroes")
            }

            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")
                adapter.updateItems(response.body()!!)
            }
        })
    }
}