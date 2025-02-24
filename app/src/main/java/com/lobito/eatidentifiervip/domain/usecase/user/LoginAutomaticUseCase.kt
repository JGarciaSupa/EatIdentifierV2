package com.lobito.eatidentifiervip.domain.usecase.user

import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.data.local.model.toDatabase
import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.domain.model.Session
import com.lobito.eatidentifiervip.domain.repository.UserRepository

class LoginAutomaticUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Resource<Session> {
        return try {
            val response = repository.getSessionPending()
            if (response == null) {
                Resource.Error("No pending session found")
            } else {
                Resource.Success(response)
            }
        } catch (e: Exception) {
            Resource.Error("Failed to get pending session: ${e.message}")
        }
    }
}
