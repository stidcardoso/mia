package com.teda.miaanticonceptivos.ui.methods.view.fragment

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.teda.miaanticonceptivos.R
import com.teda.miaanticonceptivos.ui.methods.presenter.QRContract
import com.teda.miaanticonceptivos.ui.methods.presenter.QRPresenter
import kotlinx.android.synthetic.main.qrcode_fragment.*


class QRCodeFragment : Fragment(), QRContract.View {

    val presenter by lazy { QRPresenter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.qrcode_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getParams()
    }

    private fun generateQR(url: String) {
        val writer = QRCodeWriter()
        try {
            val bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 512, 512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
                }
            }
            imageQR.setImageBitmap(bitmap)
        } catch (e: WriterException) {

        }
    }

    override fun showQR(url: String) {
        generateQR(url)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}