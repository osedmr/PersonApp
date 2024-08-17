package com.example.personsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.personsapp.data.repository.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterPersonViewModel@Inject constructor(var kisilerRepo: KisilerRepository): ViewModel() {

    fun save(name:String, num:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.save(name,num)
        }

    }
}