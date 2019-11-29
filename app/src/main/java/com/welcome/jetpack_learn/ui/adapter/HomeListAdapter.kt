package com.hankkin.jetpack_learn.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.welcome.jetpack_learn.data.bean.Component
import com.welcome.jetpack_learn.databinding.ListItemHomeBinding

class HomeListAdapter : ListAdapter<Component, HomeListAdapter.ViewHolder>((ComponentDiffCallback())) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item.link, item.title), item)
            itemView.tag = item
        }
    }

    private fun createOnClickListener(link: String, title: String): View.OnClickListener {
        return View.OnClickListener {
            if (link.isEmpty()) {
                Toast.makeText(it.context, "敬请期待...", Toast.LENGTH_SHORT).show()
            } else {
//                val direction = HomeFragmentDirections.actionNavigationFragmentToWebFragment(link, title)
//                it.findNavController().navigate(direction)
                Toast.makeText(it.context, "点击...", Toast.LENGTH_SHORT).show()
            }
        }
    }


    class ViewHolder(
        private val binding: ListItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Component) {
            binding.apply {
                clickListener = listener
                component = item
                executePendingBindings()
            }
        }
    }
}

private class ComponentDiffCallback : DiffUtil.ItemCallback<Component>() {

    override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem == newItem
    }
}