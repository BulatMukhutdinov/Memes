package tat.mukhutdinov.memes.list.ui

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import tat.mukhutdinov.memes.R
import tat.mukhutdinov.memes.list.domain.boundary.ListDomain
import tat.mukhutdinov.memes.list.domain.model.Meme
import tat.mukhutdinov.memes.list.domain.model.exception.FetchMemesException
import tat.mukhutdinov.memes.list.ui.boundary.ListBindings
import tat.mukhutdinov.memes.list.ui.boundary.ListViewModel
import tat.mukhutdinov.memes.list.ui.recycler.ListAdapter
import java.net.UnknownHostException
import kotlin.coroutines.CoroutineContext

class ListRetainedViewModel(
    private val domain: ListDomain
) : ListViewModel(), ListBindings {

    override val memes = MutableLiveData<List<Meme>>()

    override val error = MutableLiveData<Int>()

    override val isLoading = MutableLiveData<Boolean>()

    override fun handleCoroutineException(context: CoroutineContext, throwable: Throwable) {
        super.handleCoroutineException(context, throwable)

        isLoading.postValue(false)

        val message = when (throwable) {
            is FetchMemesException -> R.string.list_error_failed_to_fetch

            is UnknownHostException -> R.string.list_error_network

            else -> R.string.list_error_failed_to_fetch
        }

        error.postValue(message)
    }

    init {
        fetchMemes()
    }

    override fun fetchMemes() {
        isLoading.value = true

        launch {
            memes.postValue(domain.fetchMemes())

            isLoading.postValue(false)
        }
    }

    override fun createAdapter(): ListAdapter =
        ListAdapter(this)
}