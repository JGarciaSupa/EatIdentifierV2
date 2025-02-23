package com.lobito.eatidentifiervip.domain.usecase.shared

import com.lobito.eatidentifiervip.domain.repository.PreferencesRepository

class SetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    suspend operator fun invoke(key:  String, value: String) {
        preferencesRepository.setString(key, value)
    }
}