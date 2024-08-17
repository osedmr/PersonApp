package com.example.personsapp.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.airbnb.lottie.LottieDrawable
import com.example.personsapp.R
import com.example.personsapp.databinding.FragmentPersonBinding
import com.example.personsapp.ui.adapter.KisilerAdapter
import com.example.personsapp.ui.viewmodels.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Person : Fragment() {
    private lateinit var binding:FragmentPersonBinding
    private lateinit var viewModel: PersonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_person,container,false)
        binding.person=this
        lottieIcon()

        viewModel.kisilerList.observe(viewLifecycleOwner){
            val kisilerAdapter=KisilerAdapter(requireContext(), it.toMutableList(),viewModel)
            binding.kisilerAdapter=kisilerAdapter
        }

        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    viewModel.search(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.search(newText)
                }
                return true
            }


        })
       
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun lottieIcon(){
        binding.addButton.apply {
            setAnimation(R.raw.fab)
            playAnimation()
            repeatCount= LottieDrawable.INFINITE
        }
    }
    fun fabButton(it:View){
            Navigation.findNavController(it).navigate(R.id.personToRegisterPerson)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriyukle()
    }
}