package com.example.hotelapplication.app.ui.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.hotelapplication.R
import com.example.hotelapplication.app.utils.ViewModelFactory
import com.example.hotelapplication.databinding.FragmentRoomBinding

class RoomFragment : Fragment(R.layout.fragment_room) {
    lateinit var binding: FragmentRoomBinding
    private val viewModel: RoomViewModel by viewModels { ViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomBinding.inflate(inflater, container, false)


        val recyclerView = binding.rvRooms.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
        viewModel.getRooms()
        viewModel.rooms.observe(viewLifecycleOwner) {
            recyclerView.adapter = RoomAdapter(it, requireContext()) {
                findNavController().navigate(R.id.bookingFragment)
            }
        }


        return binding.root
    }
}