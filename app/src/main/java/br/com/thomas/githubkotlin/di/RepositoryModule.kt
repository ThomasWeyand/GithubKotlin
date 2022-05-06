package br.com.thomas.githubkotlin.di

import br.com.thomas.githubkotlin.network.GithubApi
import br.com.thomas.githubkotlin.repository.GithubRepository
import br.com.thomas.githubkotlin.repository.IGithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { getGithubRepository(get()) }
}

fun getGithubRepository(api: GithubApi) : IGithubRepository {
    return GithubRepository(api)
}