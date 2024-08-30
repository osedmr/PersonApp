package com.example.personsapp.ui.viewmodels

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.personsapp.data.repository.KisilerRepository
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterPersonViewModel@Inject constructor(var kisilerRepo: KisilerRepository): ViewModel() {

    val toastMessage = MutableStateFlow<String?>(null)

    fun save(name: String, num: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val message = kisilerRepo.save(name, num)
            withContext(Dispatchers.Main) {
                toastMessage.value = message
            }
        }
    }

}