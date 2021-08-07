package tat.mukhutdinov.memes.list.ui.boundary

import androidx.lifecycle.LiveData
import tat.mukhutdinov.memes.list.domain.model.Meme

interface ListBindings {

    val isLoading: LiveData<Boolean>
}