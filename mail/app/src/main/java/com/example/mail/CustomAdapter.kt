package com.example.mail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//data class InboxItem(val avatarResourceId: Int, val accountName: String, val messageContent: String)
data class InboxItem(val avatarResourceId: Int, val accountName: String, val messageContent: String, var isFavorite: Boolean)

class CustomAdapter(context: Context, resource: Int, items: List<InboxItem>) :
    ArrayAdapter<InboxItem>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_inbox, parent, false)
        val item = getItem(position)

        val avatarImageView = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val accountNameTextView = itemView.findViewById<TextView>(R.id.accountNameTextView)
        val messageContentTextView = itemView.findViewById<TextView>(R.id.messageContentTextView)
        val favoriteImageView = itemView.findViewById<ImageView>(R.id.favoriteImageView)

        avatarImageView.setImageResource(item?.avatarResourceId ?: R.drawable.avt_default)
        accountNameTextView.text = item?.accountName
        messageContentTextView.text = item?.messageContent
        favoriteImageView.setImageResource(R.drawable.unselected_star)
        favoriteImageView.setOnClickListener {
            item?.isFavorite = !item?.isFavorite!!

            if (item.isFavorite) {
                favoriteImageView.setImageResource(R.drawable.selected_star)
            } else {
                favoriteImageView.setImageResource(R.drawable.unselected_star)
            }
        }

        return itemView
    }

}
