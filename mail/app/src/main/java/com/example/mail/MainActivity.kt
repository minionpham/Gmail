package com.example.mail

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inboxListView: ListView = findViewById(R.id.inboxListView)
        val inboxItems = mutableListOf(
            InboxItem(R.drawable.oip, "tran", "Nội dung tin nhắn",true),
            InboxItem(R.drawable.oip, "pham", "Nội dung tin nhắn",true),
            InboxItem(R.drawable.oip, "quynh", "Nội dung tin nhắn ",false),
            InboxItem(R.drawable.oip, "thanh", "Nội dung tin nhắn",true),
            InboxItem(R.drawable.oip, "long", "Nội dung tin nhắn ",true),
            InboxItem(R.drawable.oip, "tnam", "Nội dung tin nhắn ",true),
            InboxItem(R.drawable.oip, "hai", "Nội dung tin nhắn",true),
            InboxItem(R.drawable.oip,"panh", "Nội dung tin nhắn",false)
        )

        val customAdapter = CustomAdapter(this, R.layout.list_item_inbox, inboxItems)
        inboxListView.adapter = customAdapter
    }

}
