package tat.mukhutdinov.memes.list.domain.boundary

import tat.mukhutdinov.memes.list.domain.model.Meme

interface ListGateway {

    suspend fun fetchMemes(): List<Meme>
}