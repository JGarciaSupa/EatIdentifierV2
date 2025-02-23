package com.lobito.appbusesvip.data.repository

import android.util.Log
import com.lobito.appbusesvip.BuildConfig
import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.di.Qualifiers
import com.lobito.appbusesvip.domain.usecase.dataInit.GetAbsentismoUseCase
import com.lobito.appbusesvip.domain.usecase.dataInit.GetInventoryUseCase
import com.lobito.appbusesvip.domain.usecase.dataInit.UpdateAbsentismoUseCase
import com.lobito.appbusesvip.domain.usecase.shared.GetPreferenceUseCase
import com.lobito.appbusesvip.domain.usecase.shared.SetPreferenceUseCase
import com.lobito.appbusesvip.domain.usecase.token.TokenBusesUseCase
import com.lobito.appbusesvip.domain.usecase.token.TokenSecurityUseCase
import com.lobito.appbusesvip.domain.usecase.token.TokenEmployeeUseCase
import com.lobito.appbusesvip.domain.usecase.token.TokenInventoryUseCase
import kotlinx.coroutines.delay

class SyncRepositoryImpl(
    private val tokenSecurityUseCase: TokenSecurityUseCase,
    private val tokenEmployeeUseCase: TokenEmployeeUseCase,
    private val tokenBusesUseCase: TokenBusesUseCase,
    private val tokenInventoryUseCase: TokenInventoryUseCase,
    private val setPreferenceUseCase : SetPreferenceUseCase,
    private val getPreferenceUseCase: GetPreferenceUseCase,
    private val getAbsentismoUseCase: GetAbsentismoUseCase,
    private val updateAbsentismoUseCase: UpdateAbsentismoUseCase,
    private val getInventoryUseCase: GetInventoryUseCase,
) {
    suspend fun getTokenSecurity(): Boolean {
        return try {
            val request = RequestTokenDTO(
                password = BuildConfig.PASSWORD_TOKEN_BUSES,
                username = BuildConfig.USER_TOKEN_BUSES
            )
            val response = tokenSecurityUseCase(request)

            if (response.success == "true") {
                setPreferenceUseCase(Qualifiers.tokenSecurity.toString(), response.accessToken.toString())
                Log.i("SyncRepository", "Token Buses almacenado correctamente")
                true
            } else {
                Log.e("SyncRepository", "Error en Token Buses: ${response.message}")
                false
            }
        } catch (e: Exception) {
            Log.e("SyncRepository", "Error al obtener Token Buses", e)
            //TODO [JUAN-LOG] insertar en sqliteERROR
            false
        }
    }

    suspend fun getTokenEmployee(): Boolean {
        return try {
            val request = RequestTokenDTO(
                password = BuildConfig.PASSWORD_TOKEN_EMPLOYEE,
                username = BuildConfig.USER_TOKEN_EMPLOYEE
            )
            val response = tokenEmployeeUseCase(request)

            if (response.isNotEmpty()) {
                setPreferenceUseCase(Qualifiers.tokenEmployee.toString(), response)
                Log.i("SyncRepository", "Token Employee $response")
                true
            } else {
                Log.e("SyncRepository", "Error en Token Employee: respuesta vacía")
                false
            }
        } catch (e: Exception) {
            //TODO [JUAN-LOG] insertar en sqliteERROR
            Log.e("SyncRepository", "Error al obtener Token Employee", e)
            false
        }
    }

    suspend fun getTokenBuses(): Boolean { // EN DUDA DE SI USARLO O SOLO REUTILIZAR LO QUE EXISTE
        return try {
            val request = RequestTokenDTO(
                password = BuildConfig.PASSWORD_TOKEN_BUSES,
                username = BuildConfig.USER_TOKEN_BUSES
            )
            val response = tokenBusesUseCase(request)

            if (response.success == "true") {
                setPreferenceUseCase(Qualifiers.tokenBuses.toString(), response.accessToken.toString())
                Log.i("SyncRepository", "Token Buses almacenado correctamente")
                true
            } else {
                Log.e("SyncRepository", "Error en Token Buses: ${response.message}")
                false
            }
        } catch (e: Exception) {
            Log.e("SyncRepository", "Error al obtener Token Buses", e)
            //TODO [JUAN-LOG] insertar en sqliteERROR
            false
        }
    }

    suspend fun getTokenInventory(): Boolean {
        return try {
            val request = RequestTokenDTO(
                password = BuildConfig.PASSWORD_TOKEN_EMPLOYEE,
                username = BuildConfig.USER_TOKEN_EMPLOYEE
            )
            val response = tokenInventoryUseCase(request)

            if (response.isNotEmpty()) {
                setPreferenceUseCase(Qualifiers.tokenInventory.toString(), response)
                Log.i("SyncRepository", "Token Inventory almacenado correctamente")
                true
            } else {
                Log.e("SyncRepository", "Error en Token Inventory: respuesta vacía")
                false
            }
        } catch (e: Exception) {
            //TODO [JUAN-LOG] insertar en sqliteERROR
            Log.e("SyncRepository", "Error al obtener Token Inventory", e)
            false
        }
    }

    suspend fun syncTokens() {
        // TODO [JUAN] Se deja inventario endpoints no utilizables
        var tokenSecurityOk = getPreferenceUseCase(Qualifiers.tokenBuses.toString())?.isNotEmpty() ?: false
        var tokenEmployeeOk = getPreferenceUseCase(Qualifiers.tokenEmployee.toString())?.isNotEmpty() ?: false
        var tokenBusesOk = getPreferenceUseCase(Qualifiers.tokenBuses.toString())?.isNotEmpty() ?: false
//        var tokenInventoryOk = getPreferenceUseCase(Qualifiers.tokenInventory.toString())?.isNotEmpty() ?: false

        while (!tokenSecurityOk || !tokenEmployeeOk || !tokenBusesOk) {//|| !tokenInventoryOk) {
            if (!tokenSecurityOk) tokenSecurityOk = getTokenSecurity()
            if (!tokenEmployeeOk) tokenEmployeeOk = getTokenEmployee()
            if (!tokenBusesOk) tokenBusesOk = getTokenBuses()
//            if (!tokenInventoryOk) tokenInventoryOk = getTokenInventory()

            if (tokenSecurityOk && tokenEmployeeOk && tokenBusesOk) {// && tokenInventoryOk) {
                Log.i("SyncRepository", "Todos los tokens almacenados exitosamente")
                break
            }

            Log.w("SyncRepository", "No se pudieron obtener ambos tokens, reintentando en 10 segundos...")
            delay(10000)
        }

        Log.i("SyncRepository", "Iniciando flujo normal de consultas cada 1 hora")
    }

    suspend fun getAbsentismoFromApi() {
        val response = getAbsentismoUseCase()
        updateAbsentismoUseCase(response)
    }

    suspend fun getInventoryFromApi() {
        val response = getAbsentismoUseCase()
        updateAbsentismoUseCase(response)
    }




}
