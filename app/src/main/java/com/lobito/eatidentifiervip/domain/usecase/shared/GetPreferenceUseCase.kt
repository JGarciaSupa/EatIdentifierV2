package com.lobito.eatidentifiervip.domain.usecase.shared

import com.lobito.eatidentifiervip.domain.repository.PreferencesRepository


class GetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    suspend operator fun invoke(key: String): String? {
        return preferencesRepository.getString(key)
    }
}
