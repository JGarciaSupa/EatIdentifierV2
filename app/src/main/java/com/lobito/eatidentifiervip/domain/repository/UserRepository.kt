package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO
import com.lobito.eatidentifiervip.domain.model.Session

interface UserRepository {
    suspend fun trunkUsersPending()
    suspend fun insertSession(session : Session)
    suspend fun updateSession(session : Session)
    suspend fun logoutSession(idUser : String)
    suspend fun getSessionPending() : Session
    suspend fun postLoginFromApi(session: RequestSessionDTO): Session
}
