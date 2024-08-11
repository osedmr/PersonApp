package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personsapp.data.entity.Kisiler
import com.example.personsapp.data.repository.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel: ViewModel() {

    val kisilerList= MutableLiveData<List<Kisiler>>()
    val kisilerRepo= KisilerRepository()
    init {
        kisileriyukle()
    }


     fun sil(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.sil(id)
            kisileriyukle()
        }
    }
    fun search(ara: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerList.value=kisilerRepo.search(ara)
        }
    }
    fun kisileriyukle(){
        CoroutineScope(Dispatchers.Main).launch {
           kisilerList.value= kisilerRepo.kisileriyukle()
        }
    }


}