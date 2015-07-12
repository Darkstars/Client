
package com.zhang.client.android;

import com.zhang.client.ResultPoint;
import com.zhang.client.ResultPointCallback;

final class ViewfinderResultPointCallback implements ResultPointCallback {

  private final ViewfinderView viewfinderView;

  ViewfinderResultPointCallback(ViewfinderView viewfinderView) {
    this.viewfinderView = viewfinderView;
  }

  @Override
  public void foundPossibleResultPoint(ResultPoint point) {
    viewfinderView.addPossibleResultPoint(point);
  }

}
