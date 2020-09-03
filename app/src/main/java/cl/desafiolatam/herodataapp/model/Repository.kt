package cl.desafiolatam.herodataapp.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.herodataapp.model.database.HeroDao
import cl.desafiolatam.herodataapp.model.database.HeroDatabase
import cl.desafiolatam.herodataapp.model.database.HeroEntity
import cl.desafiolatam.herodataapp.model.pojo.Hero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context : Context) {

    var listHero = MutableLiveData<List<Hero>>()
    var heroDatabase = HeroDatabase.getDatabase(context)

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().allHeroes()

        call.enqueue(object : Callback<List<Hero>> {
            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.d("Adapter", "Error al cargar heroes")
            }

            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")
                listHero.value = response.body()
                saveDatabase(heroConverter(response.body()!!))
            }
        })
    }

    fun heroConverter(listHero : List<Hero>) : List<HeroEntity> {
        return listHero.map { hero -> HeroEntity(hero.id, hero.name, hero.powerstats, hero.slug, hero.images) }
    }

    fun saveDatabase (listHeroEntity: List<HeroEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            heroDatabase.getHeroDao().insertHeroes(listHeroEntity)
        }
    }
}