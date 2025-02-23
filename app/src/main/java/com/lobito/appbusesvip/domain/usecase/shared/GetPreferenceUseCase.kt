package com.lobito.appbusesvip.domain.usecase.shared

import com.lobito.appbusesvip.domain.repository.PreferencesRepository


class GetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    suspend operator fun invoke(key: String): String? {
        return preferencesRepository.getString(key)
    }
}
