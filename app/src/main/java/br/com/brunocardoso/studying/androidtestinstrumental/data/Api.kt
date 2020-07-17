package br.com.brunocardoso.studying.androidtestinstrumental.data

import br.com.brunocardoso.studying.androidtestinstrumental.data.model.RepositoryWrapper
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Single<RepositoryWrapper>

}