package com.lobito.eatidentifiervip.data.remote.intereptor

import com.lobito.eatidentifiervip.di.Qualifiers
import com.lobito.eatidentifiervip.domain.usecase.shared.GetPreferenceUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class BusesInterceptor(
    private val getPreferenceUseCase: GetPreferenceUseCase
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // Obtener token de DataStore
        val token = runBlocking { getPreferenceUseCase.invoke(Qualifiers.tokenBuses.toString()) }

        // Construir nueva solicitud con el token
        val newRequest = request.newBuilder()
            .addHeader("Accept", "application/json")
        if (!token.isNullOrEmpty()) {
            newRequest.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(newRequest.build())
    }
}
