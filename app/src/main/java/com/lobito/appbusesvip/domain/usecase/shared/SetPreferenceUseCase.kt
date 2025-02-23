package com.lobito.appbusesvip.domain.usecase.shared

import com.lobito.appbusesvip.domain.repository.PreferencesRepository

class SetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    suspend operator fun invoke(key:  String, value: String) {
        preferencesRepository.setString(key, value)
    }
}