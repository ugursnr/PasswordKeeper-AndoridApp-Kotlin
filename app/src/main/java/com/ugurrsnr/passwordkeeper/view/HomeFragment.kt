package com.ugurrsnr.passwordkeeper.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.ugurrsnr.passwordkeeper.R

import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import com.ugurrsnr.passwordkeeper.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

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