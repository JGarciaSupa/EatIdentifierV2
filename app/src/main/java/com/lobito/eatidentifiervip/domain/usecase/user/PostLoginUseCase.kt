package com.lobito.eatidentifiervip.domain.usecase.user

import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.data.local.model.toDatabase
import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.domain.model.Session
import com.lobito.eatidentifiervip.domain.repository.UserRepository

class PostLoginUseCase  (
    private val repository: UserRepository
) {
    suspend operator fun invoke(session: Session): Resource<Session> {
        repository.trunkUsersPending()
        try {
            repository.insertSession(session.copy(email = session.email, password = session.password, idEmpresa = session.idEmpresa))
            val requestSessionDTO = RequestSessionDTO(
                email = session.email,
                password = session.password,
                idEmpresa = session.idEmpresa
            )
            val response = repository.postLoginFromApi(requestSessionDTO)
            repository.updateSession(response.copy(state = 1,))
            return Resource.Success(response)
        }catch (e: Exception){
            return Resource.Error(e.toString())
        }
    }
}

