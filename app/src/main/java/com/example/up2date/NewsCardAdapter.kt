package com.example.up2date

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class NewsCardAdapter : ListAdapter<Article, NewsCardAdapter.ViewCardHolder>(DIFF_UTIL_ITEM_CALLBACK) {
    companion object {
        private val DIFF_UTIL_ITEM_CALLBACK =
                object : DiffUtil.ItemCallback<Article>() {
                    override fun areItemsTheSame(oldItem: Article, newItem: Article) =
                            oldItem.title == newItem.title

                    override fun areContentsTheSame(oldItem: Article, newItem: Article) =
                            oldItem == newItem
                }
    }

    var listener : OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCardHolder {
        val binding = ViewCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewCardHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewCardHolder, position: Int) =
            holder.bind(getItem(position))


    inner class ViewCardHolder(private val binding: ViewCardBinding) :
            RecyclerView.ViewHolder(binding.root) {

        init {
            binding.cbDone.setOnClickListener {
                val todoEntity = getItem(adapterPosition)
                todoEntity.done = binding.cbDone.isChecked

                listener?.onTodoItemClicked(todoEntity)
            }
        }

        fun bind(Article: Article) {
            binding.cbDone.isChecked = Article.done
            binding.tvTitle.text = Article.title
        }

    }

    interface OnClickListener {
        fun onTodoItemClicked(todoEntity: Article)
    }
}