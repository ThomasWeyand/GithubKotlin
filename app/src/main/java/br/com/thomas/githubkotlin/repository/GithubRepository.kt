package br.com.thomas.githubkotlin.repository

import br.com.thomas.githubkotlin.mapper.mapFromResponse
import br.com.thomas.githubkotlin.model.RepositoriesVO
import br.com.thomas.githubkotlin.network.GithubApi
import br.com.thomas.githubkotlin.network.base.Result

class GithubRepository(private val api: GithubApi) : IGithubRepository {

    override suspend fun fetchRepositories(page: Int): Result<RepositoriesVO> {
        val result = api.getPopularKotlin(page = page)
        return when {
            result.isSuccessful -> {
                result.body()?.let {
                    if (it.items.isNotEmpty())
                        Result.Success(it.mapFromResponse())
                    else
                        Result.Error(Exception(result.message()))
                } ?: run {
                    Result.Error(Exception(result.message()))
                }
            }
            else -> Result.Error(Exception(result.message()))
        }
    }

}