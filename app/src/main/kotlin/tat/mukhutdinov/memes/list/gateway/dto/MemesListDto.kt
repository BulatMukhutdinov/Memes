package tat.mukhutdinov.memes.list.gateway.dto

import com.google.gson.annotations.SerializedName

class MemesListDto(
    @SerializedName("success")
    val isSuccessful: Boolean?,
    @SerializedName("data")
    val data: MemesDataDto?
)

class MemesDataDto(
    @SerializedName("memes")
    val memes: List<MemeDto>?
)