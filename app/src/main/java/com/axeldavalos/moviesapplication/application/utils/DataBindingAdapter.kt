package com.axeldavalos.moviesapplication.application.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(obj: RecyclerViewViewModel) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }
}

abstract class BaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, ViewHolder>(
    AsyncDifferConfig.Builder<T>(diffCallback)
        .build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item as RecyclerViewViewModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    override fun getItemCount(): Int =  if (currentList == null)  0 else currentList!!.size

    private fun getObjForPosition(position: Int) = currentList?.get(position) as RecyclerViewViewModel

    protected abstract fun getLayoutIdForPosition(position: Int): Int
}