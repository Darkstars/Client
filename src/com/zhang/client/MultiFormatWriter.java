

package com.zhang.client;

import com.zhang.aztec.AztecWriter;
import com.zhang.common.BitMatrix;
import com.zhang.datamatrix.DataMatrixWriter;
import com.zhang.oned.CodaBarWriter;
import com.zhang.oned.Code128Writer;
import com.zhang.oned.Code39Writer;
import com.zhang.oned.EAN13Writer;
import com.zhang.oned.EAN8Writer;
import com.zhang.oned.ITFWriter;
import com.zhang.oned.UPCAWriter;
import com.zhang.pdf417.PDF417Writer;
import com.zhang.qrcode.QRCodeWriter;

import java.util.Map;


public final class MultiFormatWriter implements Writer {

  @Override
  public BitMatrix encode(String contents,
                          BarcodeFormat format,
                          int width,
                          int height) throws WriterException {
    return encode(contents, format, width, height, null);
  }

  @Override
  public BitMatrix encode(String contents,
                          BarcodeFormat format,
                          int width, int height,
                          Map<EncodeHintType,?> hints) throws WriterException {

    Writer writer;
    switch (format) {
      case EAN_8:
        writer = new EAN8Writer();
        break;
      case EAN_13:
        writer = new EAN13Writer();
        break;
      case UPC_A:
        writer = new UPCAWriter();
        break;
      case QR_CODE:
        writer = new QRCodeWriter();
        break;
      case CODE_39:
        writer = new Code39Writer();
        break;
      case CODE_128:
        writer = new Code128Writer();
        break;
      case ITF:
        writer = new ITFWriter();
        break;
      case PDF_417:
        writer = new PDF417Writer();
        break;
      case CODABAR:
        writer = new CodaBarWriter();
        break;
      case DATA_MATRIX:
        writer = new DataMatrixWriter();
        break;
      case AZTEC:
        writer = new AztecWriter();
        break;
      default:
        throw new IllegalArgumentException("No encoder available for format " + format);
    }
    return writer.encode(contents, format, width, height, hints);
  }

}
