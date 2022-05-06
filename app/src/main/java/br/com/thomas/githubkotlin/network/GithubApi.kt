package br.com.thomas.githubkotlin.network

import br.com.thomas.githubkotlin.network.response.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getPopularKotlin(
        @Query("q") searchTopic: String = "language:Kotlin",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 100
    ): Response<RepositoryResponse>

}