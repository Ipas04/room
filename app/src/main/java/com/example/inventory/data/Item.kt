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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class Item( //salah satu komponen room yaitu membuat entitas atau tabel untuk menyimpan data, pada entitas ini memiliki atribut seperti dibawah
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // atribut ini sebagai primary key yang memiliki tipe data integer
    val name: String, // atribut ini menggunakan tipe data string untuk menyimpan data nama-nama barang
    val price: Double, // atribut ini menggunakan tipe data double untuk menyimpan data harga barang
    val quantity: Int // atribut ini menggunakan tipe data integer untuk menyimpan data jumlah barang
)
// setelah membuat entitas sellanjutnya membuat DAO untuk melakukan penambahan, memperbarui, menghapus dll pada data