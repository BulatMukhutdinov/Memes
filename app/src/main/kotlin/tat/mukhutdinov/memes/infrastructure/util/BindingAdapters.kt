package tat.mukhutdinov.memes.infrastructure.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import tat.mukhutdinov.memes.R

@BindingAdapter("url")
fun setImageUrl(view: ImageView, url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.color.placeholder)
        .into(view)
}
