package tat.mukhutdinov.memes.list.domain.boundary

import tat.mukhutdinov.memes.list.domain.model.Meme

interface ListDomain {

    suspend fun fetchMemes(): List<Meme>
}