package br.com.thomas.githubkotlin.repository

import br.com.thomas.githubkotlin.model.RepositoriesVO
import br.com.thomas.githubkotlin.network.base.Result

interface IGithubRepository {
    suspend fun fetchRepositories(page: Int): Result<RepositoriesVO>
}