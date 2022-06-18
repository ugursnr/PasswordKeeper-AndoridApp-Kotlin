package com.ugurrsnr.passwordkeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurrsnr.passwordkeeper.R
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding
import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordShowerBinding


class PasswordShowerFragment : Fragment() {
    private var _binding : FragmentPasswordShowerBinding? = null
    private val binding get() = _binding!!

    private lateinit var userID : String
    private lateinit var userWebsite : String
    private lateinit var userPassword : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordShowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            userID = PasswordShowerFragmentArgs.fromBundle(it).userID
            userWebsite = PasswordShowerFragmentArgs.fromBundle(it).userWebsite
            userPassword = PasswordShowerFragmentArgs.fromBundle(it).userPassword

        }
        binding.apply {
            idShowerTV.text = userID
            websiteShowerTV.text = userWebsite
            passwordShowerTV.text = userPassword
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}