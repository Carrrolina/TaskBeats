package com.comunidadedevspace.taskbeats

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TaskDetailActivity : AppCompatActivity() {

    companion object{
        val TASK_TITLE_EXTRA = "task.title.extra.detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_detail)

        val title: String = intent.getStringExtra (TASK_TITLE_EXTRA) ?: ""
        val tvTitle = findViewById<TextView>(R.id.tv_task_title_detail)

        tvTitle.text = title
    }
}