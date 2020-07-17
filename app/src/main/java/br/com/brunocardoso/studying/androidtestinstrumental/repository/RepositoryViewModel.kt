package br.com.brunocardoso.studying.androidtestinstrumental.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.brunocardoso.studying.androidtestinstrumental.data.Api
import br.com.brunocardoso.studying.androidtestinstrumental.data.RetrofitConfig.Companion.createApi
import br.com.brunocardoso.studying.androidtestinstrumental.data.model.Repository

class RepositoryViewModel(private val api: Api) : ViewModel() {

    val items = MutableLiveData<List<Repository>>()
    val error = MutableLiveData<Throwable>()

    fun fetchRepositories() {
        api.getRepositories()
            .subscribe({
                items.postValue(it.items)
            }, {
                error.postValue(it)
            })
    }

    class RepositoryViewModelFactory(private val baseUrl: String): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel>create(modelClass: Class<T>) = RepositoryViewModel(createApi(baseUrl)) as T
    }
}