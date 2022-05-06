package br.com.thomas.githubkotlin.network.response

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("node_id") val nodeID: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("owner") val owner: OwnerResponse,
    @SerializedName("html_url") val htmlUrl: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("fork") val fork: Boolean?,
    @SerializedName("size") val size: Int?,
    @SerializedName("stargazers_count") val stargazersCount: Int?,
    @SerializedName("watchers_count") val watchersCount: Int?,
    @SerializedName("language") val language: String?,
    @SerializedName("forks_count") val forksCount: Int?,
    @SerializedName("default_branch") val defaultBranch: String?,
    @SerializedName("score") val score: Float?
)
