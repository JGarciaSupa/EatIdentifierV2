package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.domain.usecase.shared.GetPreferenceUseCase
import com.lobito.eatidentifiervip.domain.usecase.shared.SetPreferenceUseCase

class SyncRepositoryImpl(
    private val getDataStoreRepositoryImpl: SetPreferenceUseCase,
    private val setDataStoreRepositoryImpl: GetPreferenceUseCase,
) {


}