/*
 * ��Ȩ����  �ź��
 * ģ�鹦�ܣ�
 * 
 */

package com.zhang.client;

import com.zhang.common.BitArray;
import com.zhang.common.BitMatrix;

/**
 * 
 *
 * @author �ź��
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
   *��ȡͼƬ�е�RGB�е�B�ĳɷ�
   * @return ͼƬԭɫ�еĺ�ɫ
   */
  public abstract BitArray getBlackRow(int y, BitArray row) throws NotFoundException;

  /*
   * ת��һ����άͼƬ
   * 
   */
  public abstract BitMatrix getBlackMatrix() throws NotFoundException;

  /*
   * ת��ͼƬ����ͼƬ֧�ֶ�ֵ������
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
