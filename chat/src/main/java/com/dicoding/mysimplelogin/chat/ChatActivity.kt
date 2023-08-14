package com.dicoding.mysimplelogin.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rickyslash.core.SessionManager
import com.rickyslash.core.UserRepository

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val tvChat = findViewById<TextView>(R.id.tv_chat)
        val sesi = SessionManager(this)
        val userRepository = UserRepository.getInstance(sesi)
        tvChat.text = "Hello ${userRepository.getUser()}! \n Welcome to Chat Feature"

    }
}