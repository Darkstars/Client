
package com.zhang.client.android;

import com.google.zxing.client.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public final class HelpActivity extends Activity {

  private static final String BASE_URL =
      "file:///android_asset/html-" + LocaleManager.getTranslatedAssetLanguage() + '/';

  private WebView webView;

  @Override
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.help);

    webView = (WebView) findViewById(R.id.help_contents);

    if (icicle == null) {
      webView.loadUrl(BASE_URL + "index.html");
    } else {
      webView.restoreState(icicle);
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle state) {
    String url = webView.getUrl();
    if (url != null && !url.isEmpty()) {
      webView.saveState(state);
    }
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
      webView.goBack();
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

}
