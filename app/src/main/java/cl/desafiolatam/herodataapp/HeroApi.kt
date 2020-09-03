package cl.desafiolatam.herodataapp

import cl.desafiolatam.herodataapp.model.pojo.Hero
import retrofit2.Call
import retrofit2.http.GET

interface HeroApi {

    @GET("all.json")
    fun allHeroes() : Call<List<Hero>>

}