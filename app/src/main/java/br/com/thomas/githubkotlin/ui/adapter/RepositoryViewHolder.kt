package br.com.thomas.githubkotlin.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.githubkotlin.databinding.RepositoryItemBinding
import br.com.thomas.githubkotlin.model.Item
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class RepositoryViewHolder(private val binding: RepositoryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.apply {
            setProfilePic(item.owner.avatarUrl, profilePic)

            title.text = item.name
            description.text = item.description
            forkCount.text = item.forksCount.toString()
            starsCount.text = item.stargazersCount.toString()

            username.text = item.owner.login
        }
    }

    private fun setProfilePic(url: String, target: AppCompatImageView?) {
        target?.apply {
            context?.let { safeContext ->
                Glide.with(safeContext)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(this)
            }
        }
    }

}