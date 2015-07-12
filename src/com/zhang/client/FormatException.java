

package com.zhang.client;

/**
 * 解码中有关于格式错误的处理类
 *
 * @author 张洪斌
 */
public final class FormatException extends ReaderException {

  private static final FormatException instance = new FormatException();

  private FormatException() {
    
  }

  public static FormatException getFormatInstance() {
    return instance;
  }

}