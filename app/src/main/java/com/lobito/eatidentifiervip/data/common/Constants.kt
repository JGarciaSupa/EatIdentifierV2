package com.lobito.eatidentifiervip.data.common

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.ByteArrayOutputStream
import java.io.File
import kotlin.math.roundToInt


object Constants {


    const val LF: Byte = 0x0A
    val INIT_SEQUENCE_858= byteArrayOf(0x1B, 0x74, 0x10)
    val RESET_PRINTER = byteArrayOf(0x1B, 0x40)
    val TEXT_ALIGN_LEFT = byteArrayOf(0x1B, 0x61, 0x00)
    val TEXT_ALIGN_CENTER = byteArrayOf(0x1B, 0x61, 0x01)
    val TEXT_ALIGN_RIGHT = byteArrayOf(0x1B, 0x61, 0x02)
    val TEXT_WEIGHT_NORMAL = byteArrayOf(0x1B, 0x45, 0x00)
    val TEXT_WEIGHT_BOLD = byteArrayOf(0x1B, 0x45, 0x01)
    val LINE_SPACING_24 = byteArrayOf(0x1B, 0x33, 0x18)
    val LINE_SPACING_30 = byteArrayOf(0x1B, 0x33, 0x1E)
    val TEXT_FONT_A = byteArrayOf(0x1B, 0x4D, 0x00)
    val TEXT_FONT_B = byteArrayOf(0x1B, 0x4D, 0x01)
    val TEXT_SIZE_NORMAL = byteArrayOf(0x1D, 0x21, 0x00)
    val TEXT_SIZE_DOUBLE_HEIGHT = byteArrayOf(0x1D, 0x21, 0x01)
    val TEXT_SIZE_DOUBLE_WIDTH = byteArrayOf(0x1D, 0x21, 0x10)
    val TEXT_SIZE_BIG = byteArrayOf(0x1D, 0x21, 0x11)
    val TEXT_UNDERLINE_OFF = byteArrayOf(0x1B, 0x2D, 0x00)
    val TEXT_UNDERLINE_ON = byteArrayOf(0x1B, 0x2D, 0x01)
    val TEXT_DOUBLE_STRIKE_OFF = byteArrayOf(0x1B, 0x47, 0x00)
    val TEXT_DOUBLE_STRIKE_ON = byteArrayOf(0x1B, 0x47, 0x01)
    val TEXT_COLOR_BLACK = byteArrayOf(0x1B, 0x72, 0x00)
    val TEXT_COLOR_RED = byteArrayOf(0x1B, 0x72, 0x01)
    val TEXT_COLOR_REVERSE_OFF = byteArrayOf(0x1D, 0x42, 0x00)
    val TEXT_COLOR_REVERSE_ON = byteArrayOf(0x1D, 0x42, 0x01)
    val CUT_PAPER = byteArrayOf(0x1D, 0x56, 0x01)
    val CUT_PAPER_2= byteArrayOf(0x1D,0x56,0x41,0x10)
    val CUT_PAPER_3 = byteArrayOf(0x10, 0x10, 0x1B, 0x69) // CUT_PAPER_3
    val FEED_PAPER_SHORT = byteArrayOf(0x1B, 0x64, 0x05)


    // Comando de alimentación de papel (n puntos)
    fun feedPaper(points: Int): ByteArray {
        return byteArrayOf(0x1B, 0x4A, points.toByte())
    }
    // Comando de estado de la impresora
    val REQUEST_PRINTER_STATUS = byteArrayOf(0x10, 0x04, 0x02)

    fun decodeBase64ToBytes(base64String: String): ByteArray {
        return android.util.Base64.decode(base64String, android.util.Base64.NO_WRAP)
        //return Base64.getDecoder().decode(base64String)
    }


    fun prepareBitmapForPrinting(bitmap: Bitmap, printerWidthMm: Int = 80): Bitmap {
        // Convertir mm a pixels (asumiendo una densidad de 8 dots/mm para impresoras térmicas)
        val dotsPerMm = 8
        val printerWidthPixels = printerWidthMm * dotsPerMm

        // Calcular nueva altura manteniendo el aspect ratio
        val aspectRatio = bitmap.height.toFloat() / bitmap.width.toFloat()
        val newHeight = (printerWidthPixels * aspectRatio).roundToInt()

        // Redimensionar el bitmap para ajustarse al ancho de la impresora
        return Bitmap.createScaledBitmap(bitmap, printerWidthPixels, newHeight, true)
    }

    fun bitmapToEscPosCommands(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()

        // Inicialización de la impresora
        outputStream.write(byteArrayOf(0x1B, 0x40))  // ESC @ - Inicializar impresora

        // Convertir la imagen a blanco y negro
        val threshold = 127
        val width = bitmap.width
        val height = bitmap.height

        // Calcular cuántos bytes necesitamos por línea
        val bytesPerLine = (width + 7) / 8

        // Comando para modo gráfico
        outputStream.write(byteArrayOf(0x1D, 0x76, 0x30, 0x00))

        // Enviar dimensiones de la imagen
        outputStream.write(byteArrayOf(
            (bytesPerLine % 256).toByte(),     // xL
            (bytesPerLine / 256).toByte(),     // xH
            (height % 256).toByte(),           // yL
            (height / 256).toByte()            // yH
        ))

        // Procesar la imagen línea por línea
        for (y in 0 until height) {
            var currentByte = 0
            var bitCount = 0

            for (x in 0 until width) {
                // Obtener el pixel y convertirlo a blanco y negro
                val pixel = bitmap.getPixel(x, y)
                val brightness = (((pixel shr 16) and 0xFF) +
                        ((pixel shr 8) and 0xFF) +
                        (pixel and 0xFF)) / 3

                // Agregar el bit al byte actual
                currentByte = currentByte shl 1
                if (brightness < threshold) {
                    currentByte = currentByte or 0x01
                }

                bitCount++

                // Cuando completamos 8 bits o llegamos al final de la línea
                if (bitCount == 8 || x == width - 1) {
                    // Si no completamos 8 bits, desplazar los bits restantes
                    if (x == width - 1 && bitCount < 8) {
                        currentByte = currentByte shl (8 - bitCount)
                    }

                    outputStream.write(currentByte)
                    currentByte = 0
                    bitCount = 0
                }
            }
        }
        return outputStream.toByteArray()
    }

    fun base64PdfToBitmap(context: Context, base64String: String): Bitmap {
        val decodedBytes = android.util.Base64.decode(base64String, android.util.Base64.DEFAULT)
        val tempFile = File(context.cacheDir, "temp.pdf").apply {
            writeBytes(decodedBytes)
        }

        val fileDescriptor = ParcelFileDescriptor.open(tempFile, ParcelFileDescriptor.MODE_READ_ONLY)
        val pdfRenderer = PdfRenderer(fileDescriptor)

        try {
            val scale = 2.5f
            val pageBitmaps = mutableListOf<Bitmap>()
            var totalHeight = 0

            for (i in 0 until pdfRenderer.pageCount) {
                pdfRenderer.openPage(i).use { page ->
                    val width = (page.width * scale).toInt()
                    val height = (page.height * scale).toInt()

                    val pageBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                    page.render(pageBitmap, null, Matrix().apply { setScale(scale, scale) }, PdfRenderer.Page.RENDER_MODE_FOR_PRINT)

                    // Verificar si la página está vacía
                    if (!isPageEmpty(pageBitmap)) {
                        pageBitmaps.add(pageBitmap)
                        totalHeight += height
                    } else {
                        pageBitmap.recycle()
                    }
                }
            }

            // Crear un bitmap combinado solo con las páginas válidas
            val maxWidth = pageBitmaps.maxOfOrNull { it.width } ?: 0
            val combinedBitmap = Bitmap.createBitmap(maxWidth, totalHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(combinedBitmap)
            canvas.drawColor(Color.WHITE)

            var currentHeight = 0
            for (bitmap in pageBitmaps) {
                canvas.drawBitmap(bitmap, 0f, currentHeight.toFloat(), null)
                currentHeight += bitmap.height
                bitmap.recycle()
            }

            // Recortar el espacio blanco en la parte inferior del bitmap combinado
            return trimWhiteSpaceFromBottom(combinedBitmap)
        } finally {
            pdfRenderer.close()
            fileDescriptor.close()
            tempFile.delete()
        }
    }


    fun isPageEmpty(bitmap: Bitmap, threshold: Float = 0.98f): Boolean {
        val width = bitmap.width
        val height = bitmap.height
        var whitePixelCount = 0
        val totalPixels = width * height

        for (y in 0 until height) {
            for (x in 0 until width) {
                val pixel = bitmap.getPixel(x, y)
                // Consideramos el color blanco puro como fondo
                if (pixel == Color.WHITE) {
                    whitePixelCount++
                }
            }
        }

        // Calcular porcentaje de píxeles blancos
        val whitePercentage = whitePixelCount.toFloat() / totalPixels
        return whitePercentage >= threshold
    }

    fun trimWhiteSpaceFromBottom(bitmap: Bitmap): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        val pixels = IntArray(width * height)

        // Obtener los píxeles del bitmap
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        // Buscar la última fila que contenga algo diferente a blanco
        var lastNonWhiteRow = height - 1
        for (y in height - 1 downTo 0) {
            var isRowEmpty = true
            for (x in 0 until width) {
                val pixel = pixels[y * width + x]
                // Compara si el píxel es blanco
                if (Color.red(pixel) < 240 || Color.green(pixel) < 240 || Color.blue(pixel) < 240) {
                    isRowEmpty = false
                    break
                }
            }
            if (!isRowEmpty) {
                lastNonWhiteRow = y
                break
            }
        }

        // Si no hay espacio vacío, devuelve el bitmap original
        if (lastNonWhiteRow == height - 1) {
            return bitmap
        }

        // Recortar el bitmap desde la parte superior hasta la fila encontrada
        return Bitmap.createBitmap(bitmap, 0, 0, width, lastNonWhiteRow + 1)
    }

}

