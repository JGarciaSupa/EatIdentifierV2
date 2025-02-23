package com.lobito.appbusesvip.domain.usecase.user

import com.lobito.appbusesvip.data.common.Resource
import com.lobito.appbusesvip.data.repository.LoginRepositoryImpl
import com.lobito.appbusesvip.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostLoginUseCase  (
    private val repository: UserRepository
) {
//    suspend operator fun invoke(request: RequestSessionDTO): Flow<Resource<Session>> = flow {
//        // 0. Verificar si existen pendientes y trunkarlos para generar un nuevo login
//        repository.truncatePendingSessions(
//            pendingState = Constants.PENDING,
//            trunkState = Constants.TRUNK_SESSION,
//        )
//
//        // 1. Insertar sesión inicial en estado `PENDING`
//        val initialSession = Session(
//            username = request.email,
//            password = request.password,
//            idEmpresa = request.idEmpresa,
//            state = Constants.PENDING
//        )
//        repository.insertSession(initialSession.toDatabase())
//
//        try {
//            // 2. Llamada a la API para hacer login
//            val response = repository.postLoginFromApi(request)
//
//            // 3. Verificar si el login fue exitoso
//            if (response.success && response.data != null) {
//                // Extraer datos necesarios del response
//                val idUsuario = response.data.idUsuario
//                val nameUser = response.data.nameUser
//                val tokenJwt = response.data.tokenJwt
//                val state = Constants.OPEN_SESSION
//
//                // 4. Actualizar solo las columnas específicas en la base de datos
//                repository.updateSessionData(
//                    username = request.email,
//                    idUsuario = idUsuario,
//                    nameUser = nameUser,
//                    tokenJwt = tokenJwt,
//                    state = state
//                )
//
//
//                // Emitir el éxito con los datos actualizados
//                val updatedSession = Session(
//                    username = request.email,
//                    password = request.password,
//                    idEmpresa = request.idEmpresa,
//                    idUsuario = idUsuario,
//                    nameUser = nameUser,
//                    tokenJwt = tokenJwt,
//                    state = state
//                )
//                emit(Resource.Success(updatedSession))
//            } else {
//                emit(Resource.Error("Error de login: ${response.error}"))
//            }
//        } catch (e: Exception) {
//            // Manejo de errores en la llamada
//            emit(Resource.Error("Error al realizar el login: ${e.message}"))
//        }
//    }
}

