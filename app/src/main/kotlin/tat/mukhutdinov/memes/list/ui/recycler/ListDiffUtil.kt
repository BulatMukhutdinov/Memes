package tat.mukhutdinov.memes.list.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.android.structure.recycler.Diff
import tat.mukhutdinov.memes.list.domain.model.Meme

class ListDiffUtil(
    private val oldList: List<Meme>,
    private val newList: List<Meme>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].url == newList[newItemPosition].url

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any =
        Diff(oldList[oldItemPosition], newList[newItemPosition])
}