package br.com.thomas.githubkotlin.mapper

import br.com.thomas.githubkotlin.model.Item
import br.com.thomas.githubkotlin.model.Owner
import br.com.thomas.githubkotlin.model.RepositoriesVO
import br.com.thomas.githubkotlin.network.response.RepositoryResponse
import br.com.thomas.githubkotlin.network.response.ItemResponse
import br.com.thomas.githubkotlin.network.response.OwnerResponse

fun RepositoryResponse.mapFromResponse() = RepositoriesVO(
    totalCount = totalCount,
    incompleteResults = incompleteResults,
    items = items.map { it.map() }
)

fun ItemResponse.map() = Item(
    id = id ?: -1,
    defaultBranch = defaultBranch ?: "",
    description = description ?: "",
    fork = fork ?: false,
    forksCount = forksCount ?: 0,
    fullName = fullName ?: "",
    htmlUrl = htmlUrl ?: "",
    language = language ?: "",
    name = name ?: "",
    nodeID = nodeID ?: "",
    owner = owner.map(),
    score = score ?: 0f,
    size = size ?: 0,
    stargazersCount = stargazersCount ?: 0,
    watchersCount = watchersCount ?: 0
)

fun OwnerResponse.map() = Owner(
    login = login,
    nodeID = nodeID,
    id = id,
    avatarUrl = avatarUrl,
    gravatarID = gravatarID,
    type = type,
    url = url
)