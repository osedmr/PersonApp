package com.example.personsapp.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.airbnb.lottie.LottieDrawable
import com.example.personsapp.R
import com.example.personsapp.data.entity.Kisiler

import com.example.personsapp.databinding.FragmentPersonBinding
import com.example.personsapp.ui.adapter.KisilerAdapter

class Person : Fragment() {
    private lateinit var binding:FragmentPersonBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        // Inflate the layout for this fragment
        binding= FragmentPersonBinding.inflate(inflater,container,false)

        binding.personRV.layoutManager=LinearLayoutManager(requireContext())

        lottieIcon()
        val list1=ArrayList<Kisiler>()
        val k1=Kisiler(1,"Ekrem","0000000")
        val k2=Kisiler(2,"Osman","123456789")
        val k3=Kisiler(3,"Musa","1234")
        list1.add(k1)
        list1.add(k2)
        list1.add(k3)


        val kisilerAdapter=KisilerAdapter(requireContext(),list1)
        binding.personRV.adapter=kisilerAdapter

        binding.addButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personToRegisterPerson)

        }

        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    search(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    search(newText)
                }
                return true
            }


        })
       /*/ binding.button.setOnClickListener {
            val kisi= Kisiler(1,"osman","05301680547")
            val gecis=PersonDirections.personToDetailPerson(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }*/

        return binding.root
    }


    fun search(ara:String){

    }

    fun lottieIcon(){
        binding.addButton.apply {
            setAnimation(R.raw.fab)
            playAnimation()
            repeatCount= LottieDrawable.INFINITE
        }
    }
}