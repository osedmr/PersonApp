package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.personsapp.data.entity.Kisiler
import com.example.personsapp.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(var kisilerRepo: KisilerRepository): ViewModel() {

    val kisilerList= MutableLiveData<List<Kisiler>>()

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