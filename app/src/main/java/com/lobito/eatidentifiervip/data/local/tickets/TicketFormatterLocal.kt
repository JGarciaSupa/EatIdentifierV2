package com.lobito.eatidentifiervip.data.local.tickets

import com.lobito.eatidentifiervip.data.common.Constants
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadoByCuiUseCase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TicketFormmaterLocal(
    private val getEmpleadoByCuiUseCase: GetEmpleadoByCuiUseCase,

) {


    fun getTicketEmpleado(empleado: Empleado, tipoComida : String): ByteArray {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val byteBuffer = mutableListOf<Byte>()
        byteBuffer.addAll(Constants.RESET_PRINTER.toList())
        byteBuffer.addAll(Constants.INIT_SEQUENCE_858.toList())
        byteBuffer.addAll(Constants.TEXT_ALIGN_CENTER.toList())
        byteBuffer.addAll(Constants.TEXT_WEIGHT_BOLD.toList())
        byteBuffer.addAll(Constants.TEXT_SIZE_BIG.toList())
        byteBuffer.addAll("$tipoComida\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll(Constants.TEXT_SIZE_NORMAL.toList())
        byteBuffer.addAll("******** Eat Identifier ********\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Nombre : ${empleado.nombre}\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("DNI : ${empleado.cui}\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Cargo : ${empleado.cargo}\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Hora : $currentTime \n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("**********************************\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.add(Constants.LF)

//        byteBuffer.addAll("******** DETALLE DEL PRODUCTO ********\n".toByteArray(Charsets.ISO_8859_1).toList())
//        byteBuffer.addAll(Constants.TEXT_ALIGN_LEFT.toList())
//        byteBuffer.addAll("Producto: NAME PRODUCT\n".toByteArray(Charsets.ISO_8859_1).toList())
//        byteBuffer.addAll("Descripción: DESCRIPCION \n".toByteArray(Charsets.ISO_8859_1).toList())

//        byteBuffer.add(Constants.LF)
//        byteBuffer.addAll(Constants.TEXT_ALIGN_CENTER.toList())
//        byteBuffer.addAll("¡Gracias por su compra!\n".toByteArray(Charsets.ISO_8859_1).toList())
//        byteBuffer.addAll("**********************************\n".toByteArray(Charsets.ISO_8859_1).toList())

        return byteBuffer.toByteArray()
    }


    fun getTicketPresentation(): ByteArray {
        val byteBuffer = mutableListOf<Byte>()

        byteBuffer.addAll(Constants.RESET_PRINTER.toList())
        byteBuffer.addAll(Constants.INIT_SEQUENCE_858.toList())
        byteBuffer.addAll(Constants.TEXT_ALIGN_CENTER.toList())
        byteBuffer.addAll(Constants.TEXT_WEIGHT_BOLD.toList())
        byteBuffer.addAll(Constants.TEXT_SIZE_BIG.toList())
        byteBuffer.addAll("EAT IDENTIFIER\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll(Constants.TEXT_SIZE_NORMAL.toList())
        byteBuffer.addAll("******** Contactenos ********\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Correo 1: jsupa.software@gmail.com\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Correo 2: ajoseph.mm@gmail.com\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("TELF: 925591889 - 902339968\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.add(Constants.LF)

        byteBuffer.addAll("******** DETALLE DEL PRODUCTO ********\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll(Constants.TEXT_ALIGN_LEFT.toList())
        byteBuffer.addAll("Producto: NAME PRODUCT\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("Descripción: DESCRIPCION \n".toByteArray(Charsets.ISO_8859_1).toList())

        byteBuffer.add(Constants.LF)
        byteBuffer.addAll(Constants.TEXT_ALIGN_CENTER.toList())
        byteBuffer.addAll("¡Gracias por su compra!\n".toByteArray(Charsets.ISO_8859_1).toList())
        byteBuffer.addAll("**********************************\n".toByteArray(Charsets.ISO_8859_1).toList())

//        byteBuffer.addAll(Constants.feedPaperEpson(5).toList())
//        byteBuffer.addAll(Constants.cutPaper().toList())

        return byteBuffer.toByteArray()
    }


}