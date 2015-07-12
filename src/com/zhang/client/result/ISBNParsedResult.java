

package com.zhang.client.result;

/**
 * @author jbreiden@google.com (Jeff Breidenbach)
 */
public final class ISBNParsedResult extends ParsedResult {

  private final String isbn;

  ISBNParsedResult(String isbn) {
    super(ParsedResultType.ISBN);
    this.isbn = isbn;
  }

  public String getISBN() {
    return isbn;
  }

  @Override
  public String getDisplayResult() {
    return isbn;
  }

}
