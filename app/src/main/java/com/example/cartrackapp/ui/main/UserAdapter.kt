package com.example.cartrackapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartrackapp.R
import com.example.cartrackapp.domain.model.GeoDomain
import com.example.cartrackapp.domain.model.UserDomain
import kotlinx.android.synthetic.main.user_list_item_view.view.*


class UserAdapter(private val onItemClickListener: ((GeoDomain) -> Unit)) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var usersList = listOf<UserDomain>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item_view, parent, false)
        return UserViewHolder(layout)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(usersList[position]) {
            onItemClickListener.invoke(it)
        }
    }

    override fun getItemCount(): Int = usersList.count()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.userNameTextView
        private val emailTextView: TextView = itemView.emailTextView
        private val addressTextView: TextView = itemView.addressTextView
        private val phoneTextView: TextView = itemView.phoneTextView

        fun bindData(user: UserDomain, onItemClickListener: ((GeoDomain) -> Unit)?) {
            val address = user.address
            userName.text = user.name
            emailTextView.text = user.email
            addressTextView.text = address.suite + "," + address.street + "," + address.city
            phoneTextView.text = user.phone
            itemView.setOnClickListener { onItemClickListener?.invoke(address.geo) }
        }
    }
}