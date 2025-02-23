package com.lobito.eatidentifiervip.data.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.lobito.eatidentifiervip.di.Qualifiers.myDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = myDataStore.toString())
