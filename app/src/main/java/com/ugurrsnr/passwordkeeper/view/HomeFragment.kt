package com.ugurrsnr.passwordkeeper.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.ugurrsnr.passwordkeeper.R

import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurrsnr.passwordkeeper.adapter.UserAdapter
import com.ugurrsnr.passwordkeeper.database.UserInfoDatabase
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding
import com.ugurrsnr.passwordkeeper.model.UserInformations
import com.ugurrsnr.passwordkeeper.viewmodel.HomeViewModel
import kotlinx.coroutines.*


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var userAdapter : UserAdapter
    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        userAdapter = UserAdapter(arrayListOf())
        liveDataObserver()

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewHome.adapter = userAdapter

    }

    private fun liveDataObserver(){
        viewModel.userInformationList.observe(viewLifecycleOwner, Observer{
            it?.let {
                userAdapter.updateList(it)
            }
        })

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val menuInflater = inflater
        menuInflater.inflate(R.menu.add_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_password){
            val actionToPasswordAddingFragment = HomeFragmentDirections.actionHomeFragmentToPasswordAddingFragment()
            Navigation.findNavController(view!!).navigate(actionToPasswordAddingFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}