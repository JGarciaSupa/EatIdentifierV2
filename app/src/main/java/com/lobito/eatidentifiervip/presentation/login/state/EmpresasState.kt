package com.lobito.eatidentifiervip.presentation.login.state

import com.lobito.eatidentifiervip.domain.model.Empresa

data class EmpresasState(
    val empresas: List<Empresa> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
