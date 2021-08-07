package tat.mukhutdinov.memes.list.gateway.boundary

import retrofit2.http.GET
import tat.mukhutdinov.memes.list.gateway.dto.MemesListDto

interface ListApi {

    @GET("get_memes")
    suspend fun fetchMemes(): MemesListDto
}