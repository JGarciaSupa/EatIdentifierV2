package com.lobito.appbusesvip.domain.model

data class User(
    val id: Long = 0L,
    val username: String = "",
    val password: String = ""
) {
    companion object {
        val EMPTY = User()
    }
}
