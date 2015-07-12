
package com.zhang.client;


public final class WriterException extends Exception {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public WriterException() {
  }

  public WriterException(String message) {
    super(message);
  }
  
  public WriterException(Throwable cause) {
    super(cause);
  }

}
