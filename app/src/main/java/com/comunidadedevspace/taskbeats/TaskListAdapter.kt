package com.comunidadedevspace.taskbeats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.TimerTask

class TaskListAdapter (
    private val listTask: List<Task>,
    private val openTaskDetailView: (task: Task) -> Unit
):

    RecyclerView.Adapter<TaskListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskListViewHolder (view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = listTask[position]
        holder.bind(task, openTaskDetailView)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}


class TaskListViewHolder (
    private val view: View
):  RecyclerView.ViewHolder(view){

    private val tvTitle = view.findViewById<TextView>(R.id.tv_task_title)
    private val tvDescription = view.findViewById<TextView>(R.id.tv_task_description)

    fun bind (
        task: Task,
        openTaskDetailView: (task: Task) -> Unit
    ){
        tvTitle.text = task.title
        tvDescription.text = task.description

        view.setOnClickListener{
            openTaskDetailView.invoke(task)
        }
    }
}