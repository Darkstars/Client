/*
 * ��Ȩ����  �ź��
 * ģ�鹦��  �����Ķ��ӿ�
 * 
 */

package com.zhang.client;

import java.util.Map;

/**
 * 
 * ʵ������ӿڿ��Դ�ͼƬ�а���һ�������ʽ��������
 * @author �ź��
 * @author 1079039435@qq.com
 */
public interface Reader {

  /**
   * Locates and decodes a barcode in some format within an image.
   *
   * @param image ��������ͼƬ
   * @return String ʹ����һ���������
   * @throws NotFoundException �����޷��������߽���ʧ��
   */
  Result decode(BinaryBitmap image) throws NotFoundException, ChecksumException, FormatException;

  /**
   *��һ��ͼƬ�н��룬
   * @param image ������ͼƬ
   * @param hints
    * @return String ��һ������ı���
   * @throws NotFoundException ����ʧ��
   */
  Result decode(BinaryBitmap image, Map<DecodeHintType,?> hints)
      throws NotFoundException, ChecksumException, FormatException;

  /**
   * ����ʹ�ý�������ʱ����ô˷���
   * 
   */
  void reset();

}