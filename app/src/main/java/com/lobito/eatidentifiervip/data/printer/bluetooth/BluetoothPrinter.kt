package com.lobito.eatidentifiervip.data.printer.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.lobito.eatidentifiervip.data.common.Constants
import com.lobito.eatidentifiervip.data.common.logi
import com.lobito.eatidentifiervip.data.service.PrintQueueManager
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.Printer
import com.lobito.eatidentifiervip.domain.usecase.shared.GetPreferenceUseCase
import com.lobito.eatidentifiervip.domain.usecase.shared.SetPreferenceUseCase
import java.io.IOException
import java.util.UUID


class BluetoothPrinter(
    private val setPreferenceUseCase: SetPreferenceUseCase,
    private val getPreferenceUseCase: GetPreferenceUseCase,

) : Printer {
    val printQueueManager = PrintQueueManager<PrintData>()
    private var mBluetoothAdapter: BluetoothAdapter? = null
    private var mmDevice: BluetoothDevice? = null
    private var mmSocket: BluetoothSocket? = null
    private var mmOutputStream: java.io.OutputStream? = null
    private var mmInputStream: java.io.InputStream? = null
    private var stopWorker = false
    private lateinit var workerThread: Thread
    private var readBufferPosition = 0
    private val readBuffer = ByteArray(1024)

    override fun print(data: PrintData) {
        printQueueManager.enqueuePrintJob(
            data = data,
            onComplete = {
                mmOutputStream?.write(Constants.FEED_PAPER_SHORT)
                mmOutputStream?.write(Constants.CUT_PAPER_3)
                logi("Impresión completada") },
            onError = { error -> logi("Error al imprimir: $error") },
            printFunction = { sendPrinter(it) },
            delayTime = 500L
        )
    }

    private fun sendPrinter(data: PrintData) {
        try {
            if (mmOutputStream == null) {
                findBT("BlueTooth Printer")
                openBT()
            }

//            val msg: ByteArray = Constants.decodeBase64ToBytes(data.text)
            mmOutputStream?.write(data.text.toByteArray())

        } catch (e: Exception) {
            logi("Error al imprimir: ${e.message}")
            closeBT()
        }
    }


    private fun findBT(ipImpresora: String?) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (mBluetoothAdapter == null) {
            Log.w("", "No bluetooth adapter available")
            return
        }
        if (!mBluetoothAdapter!!.isEnabled) {
            val enableBluetooth = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        }
        val pairedDevices: Set<BluetoothDevice> = mBluetoothAdapter!!.bondedDevices
        var deviceFound = false
        if (pairedDevices.isNotEmpty()) {
            for (device in pairedDevices) {
               logi("Paired device: ${device.name}")
                if (device.name == ipImpresora) {
                    mmDevice = device
                    deviceFound = true
                    logi("Found device: ${device.name}")
                    break
                }
            }
        } else {
            Log.d("Bluetooth", "No paired devices found")
        }

        if (!deviceFound) {
            mmDevice = null
            Log.w("Bluetooth", "Bluetooth device not found.")
        }
    }
    @Throws(IOException::class)
    private fun openBT() {
        if (mBluetoothAdapter?.isEnabled == true) {
            try {
                val uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
                mmSocket = mmDevice?.createRfcommSocketToServiceRecord(uuid)
                mmSocket?.connect()
                mmOutputStream = mmSocket?.getOutputStream()
                mmInputStream = mmSocket?.getInputStream()
                beginListenForData()
                Log.i("", "Bluetooth Opened")
            } catch (e: java.lang.Exception) {
                closeBT()
                logi("Error OPENBT: ${e.message}")
            }
        } else {
            Log.w("", "Bluetooth is not enabled.")
        }
    }

    private fun closeBT() {
        try {
            mmDevice = null
            stopWorker = true
            mmOutputStream?.close()
            mmInputStream?.close()
            mmSocket?.close()
            Log.i("", "Bluetooth Closed")
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun beginListenForData() {
        try {
            val handler = Handler(Looper.getMainLooper())
            val delimiter: Byte = 10
            stopWorker = false
            readBufferPosition = 0
            workerThread = Thread {
                while (!Thread.currentThread().isInterrupted && !stopWorker) {
                    try {
                        val bytesAvailable = mmInputStream?.available() ?: 0
                        if (bytesAvailable > 0) {
                            val packetBytes = ByteArray(bytesAvailable)
                            mmInputStream?.read(packetBytes)
                            for (i in 0 until bytesAvailable) {
                                val b = packetBytes[i]
                                if (b == delimiter) {
                                    val encodedBytes = ByteArray(readBufferPosition)
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.size)
                                    val data = String(encodedBytes, charset("US-ASCII"))
                                    readBufferPosition = 0
                                    handler.post { logi( data) }
                                } else {
                                    readBuffer[readBufferPosition++] = b
                                }
                            }
                        }
                    } catch (ex: IOException) {
                        stopWorker = true
                    }
                }
            }
            workerThread.start()
        } catch (e: java.lang.Exception) {
            closeBT()
            e.printStackTrace()
        }
    }

}
