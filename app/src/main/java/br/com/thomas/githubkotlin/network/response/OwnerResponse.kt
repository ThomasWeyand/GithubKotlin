package br.com.thomas.githubkotlin.network.response

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeID: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("gravatar_id") val gravatarID: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)
