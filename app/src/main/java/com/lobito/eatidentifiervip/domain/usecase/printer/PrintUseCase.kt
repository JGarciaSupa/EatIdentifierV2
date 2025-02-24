package com.lobito.eatidentifiervip.domain.usecase.printer

import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository

class PrintUseCase(
    private val repository: PrinterRepository
) {
    suspend operator fun invoke(data: PrintData, type: PrinterType) {
        repository.print(data, type)
    }
}
