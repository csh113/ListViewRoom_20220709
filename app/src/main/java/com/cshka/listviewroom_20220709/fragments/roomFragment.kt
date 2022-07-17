package com.cshka.todolist_20220717.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cshka.listviewroom_20220709.R
import com.cshka.listviewroom_20220709.R.*
import com.cshka.listviewroom_20220709.RoomData
import com.cshka.todolist_20220717.adapters.RoomRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_room.*

class roomFragment : Fragment() {

    lateinit var mTodoListAdapter: RoomRecyclerViewAdapter

    val mRoomList = ArrayList<RoomData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    /*
    lateinit var mTodoListAdapter: TodoRecyclerViewAdapter

    val todoList = ArrayList<RoomData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        todoList.add( TodoData(4.5, "오늘 수업 수강하기", "neppPlus 학원", false) )
        todoList.add( TodoData(4.0, "오늘 수업 복습하기", "집", false) )
        todoList.add( TodoData(3.5, "오늘 수업 출석하기", "neppPlus 학원", true) )
        todoList.add( TodoData(3.0, "오늘 수업 수강하기", "neppPlus 학원", false) )
        todoList.add( TodoData(2.5, "오늘 수업 수강하기", "neppPlus 학원", false) )

        mTodoListAdapter = TodoRecyclerViewAdapter(requireContext(), todoList)
        todoRecyclerView.adapter = mTodoListAdapter

        todoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }*/
}