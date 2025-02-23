package com.lobito.appbusesvip.data.remote.intereptor

import android.util.Log
import com.lobito.appbusesvip.di.Qualifiers
import com.lobito.appbusesvip.domain.usecase.shared.GetPreferenceUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class SecurityInterceptor (
    private val getPreferenceUseCase: GetPreferenceUseCase
    ) : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            // Obtener token de DataStore
            val token = runBlocking { getPreferenceUseCase.invoke(Qualifiers.tokenSecurity.toString()) }
            Log.d("SecurityInterceptor", "Usando token: $token")

            // Construir nueva solicitud con el token
            val newRequest = request.newBuilder()
                .addHeader("Accept", "application/json")
            if (!token.isNullOrEmpty()) {
                newRequest.addHeader("Authorization", "Bearer $token")
            }

            return chain.proceed(newRequest.build())
        }
    }
