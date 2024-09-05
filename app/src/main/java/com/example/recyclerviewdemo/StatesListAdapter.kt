package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StatesListAdapter(list: List<StateTable>) : RecyclerView.Adapter<StatesListAdapter.ExampleViewHolder>() {

    interface OnItemClickListener1 {
        fun onItemClicked(position: Int, view: View)
    }

    private var mList: List<StateTable>
    var onItemClick: ((StateTable) -> Unit)? = null

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tvName)
        var code: TextView = itemView.findViewById(R.id.tvCode)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.state_row, parent, false)
        return ExampleViewHolder(v)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem: StateTable = mList[position]
        holder.name.text = currentItem.name

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    init {
        mList = list
        notifyDataSetChanged()
    }
}