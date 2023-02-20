package com.example.figma.ui.getStart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.figma.R
import com.example.figma.databinding.FragmentAddBinding
import com.example.figma.databinding.FragmentGetStartBinding

class GetStartFragment : Fragment() {

    private lateinit var binding: FragmentGetStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetStart.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }
    }
}