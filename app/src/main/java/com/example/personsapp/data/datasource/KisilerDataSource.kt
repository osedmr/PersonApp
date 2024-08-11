package com.example.personsapp.data.datasource

import android.util.Log
import com.example.personsapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {


    suspend fun kisileriyukle(): List<Kisiler> =
        withContext(Dispatchers.IO) {
            val list1 = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ekrem", "0000000")
            val k2 = Kisiler(2, "Osman", "123456789")
            val k3 = Kisiler(3, "Musa", "1234")
            list1.add(k1)
            list1.add(k2)
            list1.add(k3)
            return@withContext list1
        }

    suspend fun save(name: String, num: String) {
        Log.e("Save", "$name --- $num")

    }

    suspend fun update(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("güncelle", "$kisi_id --- $kisi_ad -------- $kisi_tel")
    }

    suspend fun sil(id: Int) {
        Log.e("sil", "$id kisi silindi")
    }

    suspend fun search(ara: String):List<Kisiler> =
        withContext(Dispatchers.IO) {
            val list1 = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ekrem", "0000000")
            list1.add(k1)
            return@withContext list1
        }


}