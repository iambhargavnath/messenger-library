package com.iambhargavnath.messengerlibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.iambhargavnath.messengerlibrary.model.Message
import com.iambhargavnath.messengerlibrary.R
import com.squareup.picasso.Picasso

class MessageAdapter (
    private val messageList: List<Message>,
    private val yourUserId: String,
    private val onLongClick: (Message) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_MESSAGE_SENT = 1
        private const val VIEW_TYPE_MESSAGE_RECEIVED = 2
    }

    override fun getItemViewType(position: Int): Int {
        val message = messageList[position]
        return if (message.sender == yourUserId) {
            VIEW_TYPE_MESSAGE_SENT
        } else {
            VIEW_TYPE_MESSAGE_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_MESSAGE_SENT -> {
                val view = layoutInflater.inflate(R.layout.item_message_sent, parent, false)
                SentMessageHolder(view)
            }
            VIEW_TYPE_MESSAGE_RECEIVED -> {
                val view = layoutInflater.inflate(R.layout.item_message_received, parent, false)
                ReceivedMessageHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]
        var previousMessage: Message? = null
        if(position!=0)
        {
            previousMessage = messageList[position - 1]
        }
        when (holder) {
            is SentMessageHolder -> holder.bind(message)
            is ReceivedMessageHolder -> holder.bind(message, previousMessage)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    private inner class SentMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageView: TextView = view.findViewById(R.id.messageViewMe)
        private val messageLayout: LinearLayout = view.findViewById(R.id.messageLayoutMe)
        fun bind(message: Message) {
            messageView.text = message.content
            messageLayout.background = AppCompatResources.getDrawable(messageLayout.context, R.drawable.bg_chat_me)
            messageLayout.setOnLongClickListener {
                onLongClick(message)
                true
            }
        }
    }

    private inner class ReceivedMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageView: TextView = view.findViewById(R.id.messageViewOther)
        private val messageLayout: LinearLayout = view.findViewById(R.id.messageLayoutOther)
        private val profilePicCard: CardView = view.findViewById(R.id.profilePicCardOther)
        private val profilePic: ImageView = view.findViewById(R.id.profilePic)
        fun bind(message: Message, previousMessage: Message?) {
            messageView.text = message.content
            val imageURL = message.profilePicUrl
            Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.icon_user)
                .error(R.drawable.icon_user)
                .into(profilePic)
            val layoutParams = messageLayout.layoutParams as LinearLayout.LayoutParams
            if(previousMessage!=null)
            {
                if(previousMessage.sender!=yourUserId)
                {
                    messageLayout.background = AppCompatResources.getDrawable(messageLayout.context, R.drawable.bg_chat_other2)
                    layoutParams.setMargins(0, 0, 0, 0)
                    messageLayout.layoutParams = layoutParams
                    profilePicCard.visibility = View.INVISIBLE
                }
                else {
                    messageLayout.background = AppCompatResources.getDrawable(messageLayout.context, R.drawable.bg_chat_other)
                    layoutParams.setMargins(0, 36, 0, 0)
                    messageLayout.layoutParams = layoutParams
                    profilePicCard.visibility = View.VISIBLE
                }
            }
            else {
                layoutParams.setMargins(0, 36, 0, 0)
                messageLayout.layoutParams = layoutParams
            }
        }
    }
}