/*
 * 版权所有  张洪斌
 * 模块功能  条码阅读接口
 * 
 */

package com.zhang.client;

import java.util.Map;

/**
 * 
 * 实现这个接口可以从图片中按照一定条码格式解析条码
 * @author 张洪斌
 * @author 1079039435@qq.com
 */
public interface Reader {

  /**
   * Locates and decodes a barcode in some format within an image.
   *
   * @param image 待解析的图片
   * @return String 使用哪一个条码编码
   * @throws NotFoundException 条码无法解析或者解析失败
   */
  Result decode(BinaryBitmap image) throws NotFoundException, ChecksumException, FormatException;

  /**
   *从一张图片中解码，
   * @param image 待解码图片
   * @param hints
    * @return String 哪一种条码的编码
   * @throws NotFoundException 解码失败
   */
  Result decode(BinaryBitmap image, Map<DecodeHintType,?> hints)
      throws NotFoundException, ChecksumException, FormatException;

  /**
   * 重新使用解码器的时候调用此方法
   * 
   */
  void reset();

}