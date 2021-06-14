package com.javed.mysosapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_peoples.view.*

class SosAdapter(var peopleList: ArrayList<Sos>, private var callback: SosAdapterInterface) :
    RecyclerView.Adapter<SosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_peoples, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(peopleList[position])

    }

    override fun getItemCount(): Int = peopleList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sos: Sos) {
            itemView.tvUserName.text = sos.userName
            itemView.tvUserContact.text = sos.contact
            itemView.tvUserAddress.text = sos.address

//            itemView.setOnClickListener { v: View ->
//                val position = adapterPosition
//                Toast.makeText(
//                    itemView.context,
//                    "you clicked on item # ${position + 1}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            itemView.btnRemove.setOnClickListener {
//                callback.onItemRemoveClick(adapterPosition)
        }
    }

    fun setData(list: ArrayList<Sos>) {
//        Log.d("xyz", "String is $name")
        var name= listOf(0).toString()
        var contact= listOf(1).toString()
        var address= listOf(2).toString()
        peopleList?.add(Sos(name,contact,address))
        notifyDataSetChanged()
    }
}

