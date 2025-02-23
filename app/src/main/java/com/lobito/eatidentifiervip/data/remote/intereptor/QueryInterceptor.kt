package com.lobito.eatidentifiervip.data.remote.intereptor

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response

class QueryInterceptor(
    private val privateKey: String,
    private val publicKey: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // Construir el nuevo URL a partir del original
        val url = request.url.newBuilder().build()
        val credentials = privateKey
        val basicAuth = "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)

        // Construir la nueva solicitud con los encabezados necesarios
        val newRequest = request.newBuilder()
            .url(url)
//            .addHeader("Authorization", basicAuth)
//            .addHeader("Cookie", "sap-usercontext=sap-client=300")
//            .addHeader("Accept", "application/xml")
//            .addHeader("Content-Type", "application/xml")


        // Añadir la cabecera de control de cache si es necesario
//        if (cacheDuration > 0) {
//            newRequest.addHeader("Cache-Control", "public, max-age=$cacheDuration")
//        }

        // Construir la nueva solicitud
        return chain.proceed(newRequest.build())
    }
}
