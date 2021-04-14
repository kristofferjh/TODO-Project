package no.uia.todoapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.todo_list_task.view.*
import no.uia.todoapplication.data.TodoListData
import no.uia.todoapplication.data.TodoListTask
import no.uia.todoapplication.databinding.FragmentTodoListBinding
import no.uia.todoapplication.databinding.FragmentTodoListSummaryBinding

class TodoListSummaryAdapter : RecyclerView.Adapter<TodoListSummaryAdapter.SummaryViewHolder>() {

    private lateinit var refrence: DatabaseReference
    private var firebaseDatabase = FirebaseDatabase.getInstance().reference

    private val todoLists = mutableListOf<TodoListData>()

    class SummaryViewHolder(val binding: FragmentTodoListSummaryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todoListData: TodoListData, counter: Int) {
            binding.textView.text = todoListData.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val view = FragmentTodoListSummaryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, counter: Int) {
        holder.bind(todoLists[counter], counter)
    }

    fun updateTodoListData(newTodoList: TodoListData) {
        todoLists.add(newTodoList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = todoLists.size


}
