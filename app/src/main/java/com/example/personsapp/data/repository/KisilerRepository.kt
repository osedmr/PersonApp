package com.example.personsapp.data.repository

import com.example.personsapp.data.datasource.KisilerDataSource
import com.example.personsapp.data.entity.Kisiler
import com.example.personsapp.room.KisilerDao
import javax.inject.Inject

class KisilerRepository @Inject constructor(var kds: KisilerDataSource) {

    suspend fun save(name: String, num: String)=kds.save(name,num)


    suspend fun update(kisi_id:Int, kisi_ad:String, kisi_tel:String)=kds.update(kisi_id,kisi_ad,kisi_tel)

    suspend fun sil(id:Int)=kds.sil(id)

    suspend fun kisileriyukle():List<Kisiler> =kds.kisileriyukle()

    suspend fun search(ara: String)=kds.search(ara)
}