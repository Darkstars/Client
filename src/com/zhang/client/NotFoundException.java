
package com.zhang.client;


public final class NotFoundException extends ReaderException {

  private static final NotFoundException instance = new NotFoundException();

  private NotFoundException() {
  }

  public static NotFoundException getNotFoundInstance() {
    return instance;
  }

}