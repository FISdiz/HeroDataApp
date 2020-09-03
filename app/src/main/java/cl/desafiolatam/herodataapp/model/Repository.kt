package cl.desafiolatam.herodataapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.herodataapp.RetrofitClient
import cl.desafiolatam.herodataapp.model.pojo.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var listHero = MutableLiveData<List<Hero>>()

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
            }
        })
    }

}