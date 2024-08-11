package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.personsapp.data.repository.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailPersonViewModel:ViewModel() {
    val kisilerRepo= KisilerRepository()

    fun update(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.update(kisi_id,kisi_ad,kisi_tel)
        }
    }
}