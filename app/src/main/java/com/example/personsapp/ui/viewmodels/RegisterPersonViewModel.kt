package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.personsapp.data.repository.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterPersonViewModel: ViewModel() {
    val kisilerRepo=KisilerRepository()
    fun save(name:String, num:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.save(name,num)
        }

    }
}