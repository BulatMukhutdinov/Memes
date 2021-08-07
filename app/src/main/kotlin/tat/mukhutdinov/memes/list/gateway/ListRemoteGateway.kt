package tat.mukhutdinov.memes.list.gateway

import tat.mukhutdinov.memes.list.domain.boundary.ListGateway
import tat.mukhutdinov.memes.list.domain.model.Meme
import tat.mukhutdinov.memes.list.domain.model.exception.FetchMemesException
import tat.mukhutdinov.memes.list.gateway.boundary.ListApi

class ListRemoteGateway(private val api: ListApi) : ListGateway {

    override suspend fun fetchMemes(): List<Meme> {
        val response = api.fetchMemes()

        if (response.isSuccessful != true) {
            throw FetchMemesException
        }

        return response.data
            ?.memes
            ?.filter {
                it.name != null && it.url != null
            }
            ?.map {
                Meme(name = it.name.orEmpty(), url = it.url.orEmpty())
            }
            ?: listOf()
    }
}