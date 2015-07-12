package com.zhang.client;

/**
 * 检查解码过程中的错误
 * 
 *
 * @author 张洪斌
 */
public final class ChecksumException extends ReaderException {

  private static final ChecksumException instance = new ChecksumException();

  private ChecksumException() {
   
  }

  public static ChecksumException getChecksumInstance() {
    return instance;
  }

}