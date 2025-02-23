package com.lobito.eatidentifiervip.presentation.login.state

import com.lobito.eatidentifiervip.domain.model.User

data class LoginState(
    val user: User = User.EMPTY,
    val isloading: Boolean = false,
)
