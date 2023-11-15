package com.arch.portdomain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArgObject(val cmd: String,
                     val dateFrom: String = "",
                     val dateTo: String = "",
                     val news : String = "",
                     val country : String = "") : Parcelable
