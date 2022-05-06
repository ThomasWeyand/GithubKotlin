package br.com.thomas.githubkotlin.network.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<ItemResponse>
)