package com.ugurrsnr.passwordkeeper.adapter

import android.content.Context
import android.view.*
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurrsnr.passwordkeeper.R
import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordAddingBinding.inflate
import com.ugurrsnr.passwordkeeper.databinding.FragmentPasswordShowerBinding.inflate
import com.ugurrsnr.passwordkeeper.databinding.RecyclerViewRowBinding
import com.ugurrsnr.passwordkeeper.model.UserInformations
import com.ugurrsnr.passwordkeeper.view.HomeFragmentDirections
import com.ugurrsnr.passwordkeeper.viewmodel.InformationViewModel

class UserAdapter(val userInformationsList : ArrayList<UserInformations>, owner: ViewModelStoreOwner)
    : RecyclerView.Adapter<UserAdapter.UserInformationsViewHolder>() {


    val viewModel = ViewModelProvider(owner).get(InformationViewModel::class.java)

    class UserInformationsViewHolder(val binding: RecyclerViewRowBinding) :RecyclerView.ViewHolder(binding.root){

        /* Long Click
        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(view: View) {

        }
        override fun onLongClick(view: View): Boolean {
            Toast.makeText(view.context, "long click", Toast.LENGTH_SHORT).show()



            // Return true to indicate the click was handled
            return true
        }

         */

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInformationsViewHolder {
        val binding = RecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserInformationsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: UserInformationsViewHolder, position: Int) {
        holder.binding.websiteNameTextView.text = userInformationsList[position].websiteName
        holder.binding.idTextView.text = "ID: ${userInformationsList[position].userId}"
        //holder.binding.imageView.setImageURI()

        holder.itemView.setOnClickListener{
            val actionToPasswordShower = HomeFragmentDirections.actionHomeFragmentToPasswordShowerFragment()
            //Sending arguments to shower
            actionToPasswordShower.informationUUID = userInformationsList[position].informationId

            Navigation.findNavController(holder.itemView).navigate(actionToPasswordShower)

        }

        holder.binding.deleteButtonRV.setOnClickListener {

            viewModel.informationDelete(userInformationsList[position])
            notifyDataSetChanged()

        }



    }


    fun updateList(myList : List<UserInformations>) {
        userInformationsList.clear()
        userInformationsList.addAll(myList)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return userInformationsList.size
    }



}


