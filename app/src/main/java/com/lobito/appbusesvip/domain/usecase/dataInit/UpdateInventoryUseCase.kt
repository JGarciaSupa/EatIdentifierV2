package com.lobito.appbusesvip.domain.usecase.dataInit

import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.local.model.InventoryEntity
import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.domain.repository.AbsentismoRepository
import com.lobito.appbusesvip.domain.repository.InventoryRepository

class UpdateInventoryUseCase(private val inventoryRepository: InventoryRepository) {

    suspend operator fun invoke(newList: List<InventoryEntity>) {
        val currentList = inventoryRepository.getInventoryFromDb()

        val registrosActualizados = mutableListOf<InventoryEntity>()

        // Verificar cada nuevo registro
        newList.forEach { nuevo ->
            val existente = currentList.find { it.dni == nuevo.dni }

            if (existente == null || existente != nuevo) {
                // Si no existe en la BD o si ha cambiado, lo agregamos a la lista para actualizar
                registrosActualizados.add(nuevo)
            }
        }

        // Si hay cambios, eliminar e insertar los registros modificados
        if (registrosActualizados.isNotEmpty()) {
            inventoryRepository.deleteInventoryByDni(registrosActualizados.map { it.dni })
            inventoryRepository.insertInventory(registrosActualizados)
        }
    }
}
