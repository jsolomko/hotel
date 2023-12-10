package com.example.hotelapplication.app.ui.room

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomFragment : Fragment(R.layout.fragment_room) {
    lateinit var binding: FragmentRoomBinding
    private val viewModel by viewModels<RoomViewModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomBinding.inflate(inflater, container, false)

        initView()
        observeRooms()
        observeIOException()
        observeConnection()
        return binding.root
    }

    private fun observeRooms() {
        viewModel.getRooms()
        viewModel.rooms.observe(viewLifecycleOwner) {
            recyclerView.adapter = RoomAdapter(it, requireContext()) {
                findNavController().navigate(R.id.bookingFragment)
            }
            binding.shimmerRoom.stopShimmer()
            binding.shimmerRoom.isVisible = false
        }
    }

    private fun initView() {
        recyclerView = binding.rvRooms.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }

        binding.shimmerRoom.startShimmer()
    }

    private fun observeIOException() {
        viewModel.iOExceptionEvent.observe(viewLifecycleOwner) {
            if (it) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                builder
                    .setMessage("Ошибка сети")
                    .setTitle("I am the title")
                    .setPositiveButton("Загрузить снова") { dialog, which ->
                        viewModel.getRooms()
                    }
                    .setNegativeButton("Отбой") { dialog, which ->

                    }


                val dialog: AlertDialog = builder.create()
                dialog.show()

//                Toast.makeText(requireContext(), "Ошибка сети", Toast.LENGTH_SHORT).show()
                binding.shimmerRoom.stopShimmer()
            }
        }
    }

    private fun observeConnection() {
        viewModel.observeConnection()
        viewModel.onAvailableEvent.observe(viewLifecycleOwner) {
            if (it) viewModel.getRooms()
        }
    }

}