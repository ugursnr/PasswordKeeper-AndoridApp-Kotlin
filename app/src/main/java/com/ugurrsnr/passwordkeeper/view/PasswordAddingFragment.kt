package com.ugurrsnr.passwordkeeper.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordAddingBinding
import com.ugurrsnr.passwordkeeper.model.UserInformations
import com.ugurrsnr.passwordkeeper.viewmodel.InformationViewModel


class PasswordAddingFragment : Fragment() {
    private var _binding : FragmentPasswordAddingBinding? = null
    private val binding get() = _binding!!

    //user inputs
    private lateinit var userIDInput : String
    private lateinit var userWebsiteInput : String
    private lateinit var userPasswordInput : String
    private lateinit var viewModel : InformationViewModel

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

        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)

        binding.saveButton.setOnClickListener{

            userPasswordInput = binding.userPasswordInput.text.toString()
            userIDInput = binding.userIDInput.text.toString()
            userWebsiteInput = binding.userWebsiteInput.text.toString()

            val userInfo = UserInformations(userWebsiteInput,userIDInput,userPasswordInput)
            viewModel.informationInsert(userInfo)

            val actionToHome = PasswordAddingFragmentDirections.actionPasswordAddingFragmentToHomeFragment()

            Navigation.findNavController(it).navigate(actionToHome)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


    }

}