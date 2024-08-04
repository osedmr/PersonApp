package com.example.personsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.personsapp.R
import com.example.personsapp.databinding.FragmentRegisterPersonBinding

class RegisterPerson : Fragment() {

   private lateinit var binding:FragmentRegisterPersonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding= FragmentRegisterPersonBinding.inflate(inflater,container,false)

        binding.imageButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.saveButton.setOnClickListener {
            val name=binding.registerName.text.toString()
            val number=binding.registerPhone.text.toString()
            save(name,number)
        }



        return binding.root
    }


    fun save(name:String,num:String){
        Log.e("Save","$name --- $num")

    }

}