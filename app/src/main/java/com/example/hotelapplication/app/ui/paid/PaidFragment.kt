package com.example.hotelapplication.app.ui.paid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.FragmentBookingBinding
import com.example.hotelapplication.databinding.FragmentPaidBinding

class PaidFragment : Fragment(R.layout.fragment_paid) {
    lateinit var binding: FragmentPaidBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaidBinding.inflate(inflater, container, false)
        binding.btnSuper.setOnClickListener {
            findNavController().navigate(R.id.action_paidFragment_to_hotelFragment)
        }
        return binding.root
    }

}