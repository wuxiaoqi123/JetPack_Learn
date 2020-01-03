package com.welcome.jetpack_learn.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.welcome.jetpack_learn.data.bean.User
import com.welcome.jetpack_learn.databinding.AdapterPagingItemBinding

class PagingDemoAdapter : PagedListAdapter<User, PagingDemoAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            AdapterPagingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item), item)
            itemView.tag = item
        }
    }

    private fun createOnClickListener(item: User?): View.OnClickListener {
        return View.OnClickListener {
            Toast.makeText(it.context, item?.name, Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(private val binding: AdapterPagingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: User?) {
            binding.apply {
                clickListener = listener
                user = item
                executePendingBindings()
            }
        }
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }
}