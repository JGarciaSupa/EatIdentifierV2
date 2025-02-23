package com.lobito.eatidentifiervip.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.lobito.eatidentifiervip.data.common.dataStore
import com.lobito.eatidentifiervip.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.first

class DataStoreRepositoryImpl(private val context: Context) : PreferencesRepository {

    private val dataStore: DataStore<Preferences> = context.dataStore

    override suspend fun getString(key: String): String? {
        val dataKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataKey]
    }

    override suspend fun setString(key: String, value: String) {
        val dataKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataKey] = value
        }
    }
}
