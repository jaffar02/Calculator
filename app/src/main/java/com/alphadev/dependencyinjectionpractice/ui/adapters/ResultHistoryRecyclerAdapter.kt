package com.alphadev.dependencyinjectionpractice.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alphadev.dependencyinjectionpractice.R
import com.alphadev.dependencyinjectionpractice.databinding.ItemFaceBinding
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity
import com.alphadev.dependencyinjectionpractice.viewmodel.ResultViewModel

class ResultHistoryRecyclerAdapter(val context: Context, var itemsList: List<ResultHistoryEntity>)
    : RecyclerView.Adapter<ResultHistoryRecyclerAdapter.ViewHolderClass>() {
    inner class ViewHolderClass(val binding: ItemFaceBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = ItemFaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        holder.binding.arg1.text = itemsList[position].arg1
        holder.binding.arg2.text = itemsList[position].arg2
        holder.binding.operator.text = itemsList[position].operator
        holder.binding.result.text = itemsList[position].result
        if (position % 2 == 0) {
            holder.binding.l1.setBackgroundColor(context.resources.getColor(R.color.light_green))
        }
    }


}