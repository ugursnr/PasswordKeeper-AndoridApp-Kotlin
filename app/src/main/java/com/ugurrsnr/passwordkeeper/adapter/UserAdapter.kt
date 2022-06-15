package com.ugurrsnr.passwordkeeper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurrsnr.passwordkeeper.databinding.RecyclerViewRowBinding
import com.ugurrsnr.passwordkeeper.model.UserInformations

class UserAdapter(val userInformationsList : ArrayList<UserInformations>)
    : RecyclerView.Adapter<UserAdapter.UserInformationsViewHolder>() {

    class UserInformationsViewHolder(val binding: RecyclerViewRowBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInformationsViewHolder {
        val binding = RecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserInformationsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: UserInformationsViewHolder, position: Int) {
        holder.binding.websiteNameTextView.text = userInformationsList[position].websiteName
        holder.binding.idTextView.text = "ID: ${userInformationsList[position].userId}"
        //holder.binding.imageView.setImageURI()
    }



    override fun getItemCount(): Int {
        return userInformationsList.size
    }
}