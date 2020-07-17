package br.com.brunocardoso.studying.androidtestinstrumental.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RepositoryWrapper(val items: List<Repository>)

@Parcelize
@SuppressLint("ParcelCreator")
data class Repository(val name: String, val owner: Owner) : Parcelable

@Parcelize
@SuppressLint("ParcelCreator")
data class Owner(@SerializedName("avatar_url") val avatar: String) : Parcelable