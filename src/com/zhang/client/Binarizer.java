/*
 * 版权所有  张洪斌
 * 模块功能：
 * 
 */

package com.zhang.client;

import com.zhang.common.BitArray;
import com.zhang.common.BitMatrix;

/**
 * 
 *
 * @author 张洪斌
 */
public abstract class Binarizer {

  private final LuminanceSource source;

  protected Binarizer(LuminanceSource source) {
    this.source = source;
  }

  public final LuminanceSource getLuminanceSource() {
    return source;
  }

  /**
   *获取图片中的RGB中的B的成分
   * @return 图片原色中的黑色
   */
  public abstract BitArray getBlackRow(int y, BitArray row) throws NotFoundException;

  /*
   * 转换一个二维图片
   * 
   */
  public abstract BitMatrix getBlackMatrix() throws NotFoundException;

  /*
   * 转换图片，让图片支持二值化运算
   * 
   */
  public abstract Binarizer createBinarizer(LuminanceSource source);

  public final int getWidth() {
    return source.getWidth();
  }

  public final int getHeight() {
    return source.getHeight();
  }

}
