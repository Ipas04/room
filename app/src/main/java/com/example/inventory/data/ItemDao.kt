/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface ItemDao { // DAO item digunakan untuk menambah, memperbarui, menghapus data pada tabel

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>> // maksut dari ini adalah memanggil semua data yang berada pada atribut name dan mengurutkan dari atas ke bawah

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item> // maksut dari ini adalah memanggil semua data yang berada pada atribut id

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.

    @Insert(onConflict = OnConflictStrategy.IGNORE) //onConflict berfungsi untuk menentukan apa yang harus dilakukan Room ketika ada konflik, jadi maksut tersebut memberitahu Room untuk mengabaikan operasi penyisipan jika data sudah ada.
    suspend fun insert(item: Item) // anotasi @insert yang digunakan untuk menambah data

    @Update
    suspend fun update(item: Item) // anotasi @Update yang digunakan untuk memperbarui data

    @Delete
    suspend fun delete(item: Item) // anotasi @Delete yang digunakan untuk menghapus data
}
