package no.uia.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_todo_list.view.*
import kotlinx.android.synthetic.main.fragment_todo_list_summary.view.*
import no.uia.todoapplication.adapters.TodoListAdapter
import no.uia.todoapplication.data.TodoListData
import no.uia.todoapplication.data.TodoListTask
import no.uia.todoapplication.databinding.FragmentTodoListBinding
import no.uia.todoapplication.databinding.FragmentTodoListSummaryBinding


class TodoListFragment : Fragment() {

    private lateinit var adapter: TodoListAdapter

    private var _binding: FragmentTodoListBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TodoListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoListBinding.inflate(layoutInflater)

        val view = binding.root

        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.todoRecyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewTaskBtn.setOnClickListener {
            val taskName = view.newTodoTask.text.toString()
            val newTodoTask = TodoListTask(taskName)

            adapter.updateTodoListTask(newTodoTask)
        }
    }
}