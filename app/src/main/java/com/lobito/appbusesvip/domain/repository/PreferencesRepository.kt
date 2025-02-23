package com.lobito.appbusesvip.domain.repository

interface PreferencesRepository {
    suspend fun getString(key: String): String?
    suspend fun setString(key: String, value: String)
}
