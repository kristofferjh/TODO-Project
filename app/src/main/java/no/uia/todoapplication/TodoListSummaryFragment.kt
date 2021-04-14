package no.uia.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_todo_list_summary.*
import kotlinx.android.synthetic.main.fragment_todo_list_summary.view.*
import no.uia.todoapplication.adapters.TodoListSummaryAdapter
import no.uia.todoapplication.data.TodoListData
import no.uia.todoapplication.databinding.FragmentTodoListSummaryBinding


class TodoListSummaryFragment : Fragment() {

    private lateinit var adapter: TodoListSummaryAdapter

    private var _binding: FragmentTodoListSummaryBinding? = null
    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TodoListSummaryAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoListSummaryBinding.inflate(layoutInflater)

        val view = binding.root

        binding.todoListSummaryRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.todoListSummaryRecyclerView.adapter = adapter


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewTodoListBtn.setOnClickListener {
            val title = view.newTodoListTitle.text.toString()
            val newTodoList = TodoListData(title)

            adapter.updateTodoListData(newTodoList)
        }

    }
}