package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.SessionDao
import com.lobito.eatidentifiervip.data.local.model.toDatabase
import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.model.Session
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.repository.UserRepository

class LoginRepositoryImpl(
    private val sessionDao: SessionDao,
    private val apiService: AppService,
    ) : UserRepository {

    override suspend fun trunkUsersPending() {
        sessionDao.trunkUsersPending()
    }

    override suspend fun insertSession(session: Session) {
        sessionDao.insert(session.toDatabase())
    }

    override suspend fun updateSession(session: Session) {
        sessionDao.update(session.toDatabase())
    }

    override suspend fun logoutSession(idUser: String) {
        sessionDao.logoutSession(idUser)
    }

    override suspend fun getSessionPending(): Session {
        return sessionDao.getSessionOpen().toDomain()

    }

    override suspend fun postLoginFromApi(requestSessionDTO: RequestSessionDTO): Session {
        return apiService.postLogin(requestSessionDTO).data!!.toDomain(requestSessionDTO.email, requestSessionDTO.password, requestSessionDTO.idEmpresa)
    }

}