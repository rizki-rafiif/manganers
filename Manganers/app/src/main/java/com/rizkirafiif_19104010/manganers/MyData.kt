package com.rizkirafiif_19104010.manganers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class MyData (
    var name: String ?= null,
    var description: String ?= null,
    var photo: String ?= null,
    val lat: Double ?= null,
    val lang: Double ?= null
    ) : Parcelable