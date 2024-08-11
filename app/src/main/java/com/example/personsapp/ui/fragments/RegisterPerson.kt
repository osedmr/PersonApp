package com.example.personsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.personsapp.R
import com.example.personsapp.databinding.FragmentRegisterPersonBinding
import com.example.personsapp.ui.viewmodels.DetailPersonViewModel
import com.example.personsapp.ui.viewmodels.RegisterPersonViewModel

class RegisterPerson : Fragment() {

   private lateinit var binding:FragmentRegisterPersonBinding
   private lateinit var viewModel: RegisterPersonViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

       binding= DataBindingUtil.inflate(inflater, R.layout.fragment_register_person,container,false)

        binding.registerPersonFragment=this
        binding.toolBar = "Register Person"


        binding.imageButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: RegisterPersonViewModel by viewModels()
        viewModel=tempViewModel
    }


    fun buttonSave(name:String, num:String){
        viewModel.save(name,num)
    }

}