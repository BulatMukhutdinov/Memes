package tat.mukhutdinov.memes.list.gateway.dto

import com.google.gson.annotations.SerializedName

class MemeDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("box_count")
    val box_count: Int?
)