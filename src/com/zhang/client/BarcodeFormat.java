
/*
 * 作者：张洪斌
 * 模块作用：枚举需要处理的编码
 *   涉及常用的17中编码格式
 */
package com.zhang.client;
//处理的条码规格定义
public enum BarcodeFormat {

  /** 美国条码格式  2D AZTEC */
  AZTEC,

  /** CODABAR 1D 格式. */
  CODABAR,

  /** 39码. */
  CODE_39,

  /** 93码. */
  CODE_93,

  /** 128码. */
  CODE_128,

  /** 二维数据矩阵码. */
  DATA_MATRIX,

  /** EAN-8 码. */
  EAN_8,

  /** EAN-13 1D 码. */
  EAN_13,

  /** ITF 1D 码. */
  ITF,

  /** MaxiCode 2D */
  MAXICODE,

  /** PDF417  */
  PDF_417,

  /** QR Code 2D  */
  QR_CODE,

  /** RSS 14 */
  RSS_14,

  /** RSS EXPANDED */
  RSS_EXPANDED,

  /** UPC-A 1D  */
  UPC_A,

  /** UPC-E 1D  */
  UPC_E,

  /** UPC/EAN  */
  UPC_EAN_EXTENSION

}
