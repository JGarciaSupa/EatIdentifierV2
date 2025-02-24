package com.lobito.eatidentifiervip.data.printer

import com.lobito.eatidentifiervip.data.printer.bluetooth.BluetoothPrinter
import com.lobito.eatidentifiervip.data.printer.network.NetworkPrinter
import com.lobito.eatidentifiervip.data.printer.usb.UsbPrinter
import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.PrintData

class PrinterManager(
    private val bluetoothPrinter: BluetoothPrinter,
    private val networkPrinter: NetworkPrinter,
    private val usbPrinter: UsbPrinter
) {
    fun print(data: PrintData, type: PrinterType) {
        when (type) {
            PrinterType.BLUETOOTH -> bluetoothPrinter.print(data)
            PrinterType.NETWORK -> networkPrinter.print(data)
            PrinterType.USB -> usbPrinter.print(data)
        }
    }
}

