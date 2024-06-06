package com.comunidadedevspace.taskbeats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tasklist = listOf<Task>(
            Task("Title0", "Description0"),
            Task("Title1", "Description1"),
            Task("Title2", "Description2"),
            Task("Title3", "Description3"),
            Task("Title4", "Description4"),
            Task("Title5", "Description5"),
            Task("Title6", "Description6"),
            Task("Title7", "Description7"),
            Task("Title8", "Description8"),
            Task("Title9", "Description9"),
            Task("Title10", "Description10"),
            Task("Title11", "Description11"),
            )
        val adapter: TaskListAdapter = TaskListAdapter(tasklist, ::openTaskDetailView)

        val rvTasks: RecyclerView = findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter
    }

    private fun openTaskDetailView (task: Task){
        val intent = Intent (this, TaskDetailActivity::class.java)
            .apply {
                putExtra(TaskDetailActivity.TASK_TITLE_EXTRA, task.title)
            }
        startActivity(intent)
    }
}