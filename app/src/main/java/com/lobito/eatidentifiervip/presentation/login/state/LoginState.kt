package com.lobito.eatidentifiervip.presentation.login.state

import com.lobito.eatidentifiervip.domain.model.Session

data class LoginState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Session? = null
)