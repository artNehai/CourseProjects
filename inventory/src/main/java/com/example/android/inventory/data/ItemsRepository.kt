package com.example.android.inventory.data

import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun insertItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(item: Item)
    fun getItemStream(id: Int): Flow<Item?>
    fun getAllItemsStream(): Flow<List<Item>>
}
