package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.domain.model.PrintData

interface Printer {
    fun print(data: PrintData)
}
