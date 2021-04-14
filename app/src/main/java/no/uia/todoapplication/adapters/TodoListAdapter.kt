package no.uia.todoapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import no.uia.todoapplication.databinding.FragmentTodoListBinding
import no.uia.todoapplication.data.TodoListTask
import android.widget.TextView
import kotlinx.android.synthetic.main.todo_list_task.view.*
import no.uia.todoapplication.data.TodoListData

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    private lateinit var refrence: DatabaseReference
    private var firebaseDatabase = FirebaseDatabase.getInstance().reference

    private val todoListTasks = mutableListOf<TodoListTask>()

    inner class ViewHolder(private val binding: FragmentTodoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todoListTask: TodoListTask, counter: Int) {

            binding.todoTitle.text = todoListTask.title
            binding.todoRecyclerView.todoTaskCheckbox.isChecked = todoListTask.isDone
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            FragmentTodoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, counter: Int) {
        holder.bind(todoListTasks[counter], counter)
    }


    fun updateTodoListTask(newTodoTask: TodoListTask) {
        todoListTasks.add(newTodoTask)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = todoListTasks.size

}