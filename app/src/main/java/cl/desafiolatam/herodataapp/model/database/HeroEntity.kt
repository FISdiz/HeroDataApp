package cl.desafiolatam.herodataapp.model.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.desafiolatam.herodataapp.model.pojo.HeroImages
import cl.desafiolatam.herodataapp.model.pojo.Powerstats

@Entity (tableName = "hero_table")
data class HeroEntity (
    @PrimaryKey val id : Int,
    val name : String,
    @Embedded(prefix = "ps_") val powerstats: Powerstats,
    val slug : String,
    @Embedded(prefix = "images_") val images : HeroImages
    )