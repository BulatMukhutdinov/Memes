package tat.mukhutdinov.memes.list.domain

import tat.mukhutdinov.memes.list.domain.boundary.ListDomain
import tat.mukhutdinov.memes.list.domain.boundary.ListGateway
import tat.mukhutdinov.memes.list.domain.model.Meme

class ListInteractor(private val gateway: ListGateway) : ListDomain {

    override suspend fun fetchMemes(): List<Meme> =
        gateway.fetchMemes()
}