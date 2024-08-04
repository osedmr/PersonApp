package com.example.personsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.personsapp.databinding.FragmentDetailPersonBinding


class DetailPerson : Fragment() {

    private lateinit var binding:FragmentDetailPersonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailPersonBinding.inflate(inflater,container,false)


       val bundle: DetailPersonArgs by navArgs()

        binding.detailName.setText(bundle.kisi.kisi_ad)
        binding.detailPhone.setText(bundle.kisi.kisi_tel)

        binding.updateButton.setOnClickListener {
            val kisi=binding.detailName.text.toString()
            val number=binding.detailPhone.text.toString()
            update(bundle.kisi.kisi_id,kisi,number)
        }
        binding.imageButton.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    fun update(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        Log.e("güncelle","$kisi_id --- $kisi_ad -------- $kisi_tel")
    }


}