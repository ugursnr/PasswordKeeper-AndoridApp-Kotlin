package com.ugurrsnr.passwordkeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ugurrsnr.passwordkeeper.R
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding
import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordShowerBinding
import com.ugurrsnr.passwordkeeper.model.UserInformations
import com.ugurrsnr.passwordkeeper.viewmodel.InformationViewModel


class PasswordShowerFragment : Fragment() {
    private var _binding : FragmentPasswordShowerBinding? = null
    private val binding get() = _binding!!

    private var userIDFromDB : String = "--"
    private var userWebsiteFromDB : String ="--"
    private var userPasswordFromDB : String ="--"
    private var informationUUID : Int = -1

    private lateinit var viewModel : InformationViewModel


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
        //initialize
        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)

        //Get uuid from recycler view
        argumentsGetter()

        //put uuid to view model to read data from database
        viewModel.informationRead(informationUUID)

        //observe the output and get the information as list and show the informations on ui
        liveDataObserver()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun argumentsGetter(){
        arguments?.let {
            informationUUID = PasswordShowerFragmentArgs.fromBundle(it).informationUUID
        }
        println(informationUUID) //Test



    }

    private fun informationShower(id : String, password : String, website : String){ //düzenlenecek
        binding.apply {
            idShowerTV.text = id
            passwordShowerTV.text = password
            websiteShowerTV.text = website

        }
    }

    private fun liveDataObserver(){
        viewModel.singleInformation.observe(viewLifecycleOwner, Observer{
            it?.let {
                userIDFromDB = it[0].userId
                userPasswordFromDB = it[0].userPassword
                userWebsiteFromDB = it[0].websiteName
                //show the information on ui
                informationShower(userIDFromDB,userPasswordFromDB,userWebsiteFromDB)
            }
        })

    }


}