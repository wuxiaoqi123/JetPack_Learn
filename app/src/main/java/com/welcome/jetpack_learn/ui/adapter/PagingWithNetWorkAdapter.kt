package com.welcome.jetpack_learn.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.welcome.jetpack_learn.data.NetworkState
import com.welcome.jetpack_learn.data.bean.Gank
import com.welcome.jetpack_learn.databinding.AdapterPagingWithNetworkItemBinding

class PagingWithNetWorkAdapter : PagedListAdapter<Gank, PagingWithNetWorkAdapter.ViewHolder>(
    diffCallback
) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Gank>() {

            override fun areItemsTheSame(oldItem: Gank, newItem: Gank): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Gank, newItem: Gank): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var neworkState: NetworkState? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterPagingWithNetworkItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item), item)
            itemView.tag = item
        }
    }

    private fun createOnClickListener(item: Gank?): View.OnClickListener {
        return View.OnClickListener {
            item?.run {
                //TODO
            }
        }
    }

    class ViewHolder(private val binding: AdapterPagingWithNetworkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Gank?) {
            binding.apply {
                clickListener = listener
                gank = item
                executePendingBindings()
            }
        }
    }

    private fun hasExtraRow() = neworkState != null && neworkState != NetworkState.HIDDEN

    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.neworkState
        val hadExtraRow = hasExtraRow()
        this.neworkState = neworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }
}