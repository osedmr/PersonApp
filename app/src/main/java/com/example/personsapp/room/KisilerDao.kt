package com.example.personsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.personsapp.data.entity.Kisiler

@Dao
interface KisilerDao {

    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle(): List<Kisiler>

    //kişi kayıt
    @Insert
    suspend fun kaydet(kisi: Kisiler)
    //kisi güncelle
    @Update
    suspend fun update(kisi: Kisiler)
    @Delete
    suspend fun delete(kisi: Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%' || :name || '%'")
    fun searchByName(name: String): List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_tel = :num LIMIT 1")
    suspend fun getByNumber(num: String): Kisiler?


}