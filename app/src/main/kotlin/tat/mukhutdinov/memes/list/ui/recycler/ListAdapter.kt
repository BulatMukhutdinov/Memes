package tat.mukhutdinov.memes.list.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.android.structure.recycler.BaseAdapter
import tat.mukhutdinov.memes.list.domain.model.Meme
import tat.mukhutdinov.memes.list.ui.boundary.ListBindings

class ListAdapter(
    bindings: ListBindings
) : BaseAdapter<Meme, ListBindings, ListItemViewHolder>(bindings) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder =
        ListItemViewHolder.create(parent)

    override fun getDiffUtil(updated: List<Meme>): DiffUtil.Callback =
        ListDiffUtil(items, updated)

    override fun getItemId(position: Int): Long =
        items[position].url.hashCode().toLong()
}