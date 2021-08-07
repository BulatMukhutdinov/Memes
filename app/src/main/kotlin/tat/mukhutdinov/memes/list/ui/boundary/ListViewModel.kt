package tat.mukhutdinov.memes.list.ui.boundary

import androidx.lifecycle.LiveData
import tat.mukhutdinov.android.structure.StructureViewModel
import tat.mukhutdinov.memes.list.domain.model.Meme
import tat.mukhutdinov.memes.list.ui.recycler.ListAdapter

abstract class ListViewModel : StructureViewModel() {

    abstract val memes: LiveData<List<Meme>>

    abstract val error: LiveData<Int>

    abstract fun fetchMemes()

    abstract fun createAdapter(): ListAdapter
}