
package com.zhang.client.android.result;

import com.google.zxing.client.android.R;
import com.zhang.client.Result;
import com.zhang.client.result.ISBNParsedResult;
import com.zhang.client.result.ParsedResult;

import android.app.Activity;


public final class ISBNResultHandler extends ResultHandler {
  private static final int[] buttons = {
      R.string.button_product_search,
      R.string.button_book_search,
      R.string.button_search_book_contents,
      R.string.button_custom_product_search
  };

  public ISBNResultHandler(Activity activity, ParsedResult result, Result rawResult) {
    super(activity, result, rawResult);
  }

  @Override
  public int getButtonCount() {
    return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
  }

  @Override
  public int getButtonText(int index) {
    return buttons[index];
  }

  @Override
  public void handleButtonPress(int index) {
    ISBNParsedResult isbnResult = (ISBNParsedResult) getResult();
    switch (index) {
      case 0:
        openProductSearch(isbnResult.getISBN());
        break;
      case 1:
        openBookSearch(isbnResult.getISBN());
        break;
      case 2:
        searchBookContents(isbnResult.getISBN());
        break;
      case 3:
        openURL(fillInCustomSearchURL(isbnResult.getISBN()));
        break;
    }
  }

  @Override
  public int getDisplayTitle() {
    return R.string.result_isbn;
  }
}
