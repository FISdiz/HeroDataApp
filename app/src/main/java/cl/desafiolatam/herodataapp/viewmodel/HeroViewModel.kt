package cl.desafiolatam.herodataapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import cl.desafiolatam.herodataapp.model.Repository

public class HeroViewModel(application: Application) : AndroidViewModel(application) {

    private var repository : Repository = Repository(application)
    var listHero = repository.listHero

    init {
        repository = Repository(application)

        repository.loadApiData()

    }
}