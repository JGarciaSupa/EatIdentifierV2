package com.lobito.eatidentifiervip.domain.usecase.dataInit

import com.lobito.eatidentifiervip.data.local.model.AbsentismoEntity
import com.lobito.eatidentifiervip.domain.repository.AbsentismoRepository

class GetAbsentismoUseCase(private val absentismoRepository: AbsentismoRepository) {
    suspend operator fun invoke(): List<AbsentismoEntity> {
        val response = absentismoRepository.getAbsentismoFromApi()

        // Convertimos el DTO a nuestra lista de entidades
        return response.personal.map { dto ->
            AbsentismoEntity(
                codTrabajador = dto.codTrabajador,
                dni = dto.dni,
                codEmpresa = dto.codEmpresa,
                apellidoMat = dto.apellidoMat,
                apellidoPat = dto.apellidoPat,
                nombres = dto.nombres,
                email = dto.email,
                sexo = dto.sexo,
                estadoCivil = dto.estadoCivil,
                sedeNombre = dto.sedeNombre,
                posicionNombre = dto.posicionNombre,
                absentismo = dto.absentismo.toString(),
                licenciaDesc = dto.licenciaDesc.toString(),
                descripcion = dto.descripcion.toString(),
                areaNombre = dto.areaNombre
            )
        }
    }
}
