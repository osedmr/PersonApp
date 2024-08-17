package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.personsapp.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPersonViewModel@Inject constructor(var kisilerRepo: KisilerRepository):ViewModel() {


    fun update(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.update(kisi_id,kisi_ad,kisi_tel)
        }
    }
}