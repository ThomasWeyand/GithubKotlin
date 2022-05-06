package br.com.thomas.githubkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val login: String,
    val id: Int,
    val nodeID: String,
    val avatarUrl: String,
    val gravatarID: String,
    val url: String,
    val type: String
) : Parcelable
