package com.ugurrsnr.passwordkeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurrsnr.passwordkeeper.R
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding
import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordAddingBinding

class PasswordAddingFragment : Fragment() {
    private var _binding : FragmentPasswordAddingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordAddingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}