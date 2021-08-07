package tat.mukhutdinov.memes.list.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tat.mukhutdinov.android.structure.recycler.BaseViewHolder
import tat.mukhutdinov.memes.R
import tat.mukhutdinov.memes.databinding.ListItemBinding
import tat.mukhutdinov.memes.list.domain.model.Meme
import tat.mukhutdinov.memes.list.ui.boundary.ListBindings

class ListItemViewHolder(
    viewBinding: ListItemBinding
) : BaseViewHolder<Meme, ListBindings, ListItemBinding>(viewBinding) {

    companion object {

        fun create(parent: ViewGroup): ListItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewDataBinding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

            return ListItemViewHolder(viewDataBinding)
        }
    }
}