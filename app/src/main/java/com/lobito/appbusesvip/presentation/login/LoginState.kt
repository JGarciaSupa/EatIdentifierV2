package com.lobito.appbusesvip.presentation.login

import com.lobito.appbusesvip.domain.model.User

data class LoginState(
    val user: User = User.EMPTY,
    val isloading: Boolean = false,
)
