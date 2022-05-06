package br.com.thomas.githubkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RepositoriesVO(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: List<Item>
) : Parcelable