package com.lobito.eatidentifiervip.domain.usecase.dataInit

import com.lobito.eatidentifiervip.data.local.model.InventoryEntity
import com.lobito.eatidentifiervip.domain.repository.InventoryRepository

class GetInventoryUseCase(private val inventoryRepository: InventoryRepository) {
    suspend operator fun invoke(): List<InventoryEntity> {
        val response = inventoryRepository.getInventoryFromApi()

        return response.map { dto ->
            InventoryEntity(
                idInventario = dto.id.toString(),
                empresa = dto.empresa.orEmpty(),
                gerencia = dto.gerencia.orEmpty(),
                area = dto.area.orEmpty(),
                dni = dto.dni.orEmpty(),
                sede = dto.sede.orEmpty(),
                nombres = dto.nombres.orEmpty(),
                apellidos = dto.apellidos.orEmpty(),
                usuarioAnterior = dto.usuarioAnterior.orEmpty(),
                usuarioDominio = dto.usuarioDominio.orEmpty(),
                equipo = dto.equipo.orEmpty(),
                lote = dto.lote.orEmpty(),
                host = dto.host.orEmpty(),
                marca = dto.marca.orEmpty(),
                modelo = dto.modelo.orEmpty(),
                serie = dto.serie.orEmpty(),
                procesador = dto.procesador.orEmpty(),
                memoria = dto.memoria.orEmpty(),
                disco = dto.disco.orEmpty(),
                macRed = dto.macRed.orEmpty(),
                macWifi = dto.macWifi.orEmpty(),
                estado = dto.estado.orEmpty(),
                precioLote = dto.precioLote.orEmpty(),
                licOffice = dto.licOffice.orEmpty(),
                precioLicOffice = dto.precioLicOffice.orEmpty(),
                licSap = dto.licSap.orEmpty(),
                precioLicSap = dto.precioLicSap.orEmpty(),
                licAntivirus = dto.licAntivirus.orEmpty(),
                precioLicAntivirus = dto.precioLicAntivirus.orEmpty(),
                obs = dto.obs.orEmpty()
            )
        }
    }
}

