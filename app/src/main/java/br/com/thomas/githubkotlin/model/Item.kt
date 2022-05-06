package br.com.thomas.githubkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val id: Int,
    val nodeID: String,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val size: Int,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String,
    val forksCount: Int,
    val defaultBranch: String,
    val score: Float
) : Parcelable
