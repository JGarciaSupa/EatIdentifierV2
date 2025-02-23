package com.lobito.eatidentifiervip.domain.usecase.dataInit

import com.lobito.eatidentifiervip.data.local.model.InventoryEntity
import com.lobito.eatidentifiervip.domain.repository.InventoryRepository

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
