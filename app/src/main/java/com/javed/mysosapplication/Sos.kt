package com.javed.mysosapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sos(
    @SerializedName("userName") val userName: String?,
    @SerializedName("contact") val contact: String?,
    @SerializedName("address") val address: String?
) : Serializable
