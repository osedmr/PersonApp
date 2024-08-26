package com.example.personsapp.data.datasource

import com.example.personsapp.data.entity.Kisiler
import com.example.personsapp.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var kisilerDao: KisilerDao) {


    suspend fun kisileriyukle(): List<Kisiler> =
        withContext(Dispatchers.IO) {

            return@withContext kisilerDao.kisileriYukle()
        }
    suspend fun save(name: String, num: String):String {
        if (num.length != 11 || num.toLongOrNull() == null) {
            return "Lütfen 11 haneli bir numara giriniz"
        }
        val existingPerson = kisilerDao.getByNumber(num)
        if (existingPerson != null) {
            return "Bu numara kayıtlı"
        }
        val kisiler = Kisiler(0, name, num)
        kisilerDao.kaydet(kisiler)
        return "Başarıyla kaydedildi"
    }

    suspend fun update(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        val kisiler = Kisiler(kisi_id, kisi_ad, kisi_tel)
        kisilerDao.update(kisiler)
    }

    suspend fun sil(id: Int) {
        val silinenKisi = Kisiler(id, "", "")
        kisilerDao.delete(silinenKisi)
    }

    suspend fun search(ara: String):List<Kisiler> =
        withContext(Dispatchers.IO) {

            return@withContext kisilerDao.searchByName(ara)
        }


}