package com.lobito.eatidentifiervip.data.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentLinkedQueue

class PrintQueueManager<T> {

    private val printQueue = ConcurrentLinkedQueue<PrintJob<T>>()
    private val scope = CoroutineScope(Dispatchers.IO)
    private var isPrinting = false

    data class PrintJob<T>(
        val data: T,
        val onComplete: () -> Unit,
        val onError: (Throwable) -> Unit,
        val printFunction: suspend (T) -> Unit,
        val delayTime: Long
    )

    fun enqueuePrintJob(
        data: T,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit,
        printFunction: suspend (T) -> Unit,
        delayTime: Long
    ) {
        val printJob = PrintJob(data, onComplete, onError, printFunction, delayTime)
        printQueue.add(printJob)
        processQueue()
    }

    private fun processQueue() {
        if (isPrinting) return

        val printJob = printQueue.poll() ?: return
        isPrinting = true

        scope.launch {
            try {
                printJob.printFunction(printJob.data)
                delay(printJob.delayTime)
                printJob.onComplete()
                delay(500) // Tiempo adicional para estabilidad
            } catch (e: Exception) {
                printJob.onError(e)
            }

            isPrinting = false
            processQueue() // Llamada recursiva para procesar el siguiente en la cola
        }
    }
}
