

package com.zhang.client;


public abstract class ReaderException extends Exception {

  ReaderException() {
   
  }

  @Override
  public final Throwable fillInStackTrace() {
    return null;
  }

}
