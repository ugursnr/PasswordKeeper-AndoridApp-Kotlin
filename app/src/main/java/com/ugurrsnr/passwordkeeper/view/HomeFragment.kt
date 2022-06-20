package com.ugurrsnr.passwordkeeper.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.ugurrsnr.passwordkeeper.R

import android.view.Menu
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurrsnr.passwordkeeper.adapter.UserAdapter
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding
import com.ugurrsnr.passwordkeeper.viewmodel.InformationViewModel


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var userAdapter : UserAdapter
    private lateinit var viewModel : InformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }

        })
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

        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
        userAdapter = UserAdapter(arrayListOf(),this)
        liveDataObserver()

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewHome.adapter = userAdapter
        registerForContextMenu(binding.recyclerViewHome)
    }

    private fun liveDataObserver(){
        viewModel.userInformationList.observe(viewLifecycleOwner, Observer{
            it?.let {
                userAdapter.updateList(it)
            }
        })

    }

    //Options Menu
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
    //Options Menu

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}