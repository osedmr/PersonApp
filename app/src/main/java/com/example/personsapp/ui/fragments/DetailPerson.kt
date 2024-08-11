package com.example.personsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import com.example.personsapp.R
import com.example.personsapp.databinding.FragmentDetailPersonBinding
import com.example.personsapp.ui.viewmodels.DetailPersonViewModel
import com.example.personsapp.ui.viewmodels.RegisterPersonViewModel


class DetailPerson : Fragment() {

    private lateinit var binding:FragmentDetailPersonBinding
    private lateinit var viewModel: DetailPersonViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_detail_person,container,false)
        binding.detailPersonFragment=this


       val bundle:DetailPersonArgs by navArgs()

        val gelen_kisi=bundle.kisi
        binding.kisiNesnesi=gelen_kisi

        binding.imageButton.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailPersonViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun buttonUpdate(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        viewModel.update(kisi_id,kisi_ad,kisi_tel)
    }


}