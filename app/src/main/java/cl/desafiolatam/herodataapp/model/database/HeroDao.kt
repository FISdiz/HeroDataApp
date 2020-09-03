package cl.desafiolatam.herodataapp.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {

    //guarda y recupera informacion desde la entidad
    @Query("SELECT * FROM hero_table")
    fun getAllHeroes() : LiveData<List<HeroEntity>>

    @Insert
    fun insertHeroes(heroList : List<HeroEntity>)
    // fun insertHero(hero : HeroEntity)

}