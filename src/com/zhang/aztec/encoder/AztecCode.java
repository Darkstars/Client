

package com.zhang.aztec.encoder;

import com.zhang.common.BitMatrix;
public final class AztecCode {

  private boolean compact;
  private int size;
  private int layers;
  private int codeWords;
  private BitMatrix matrix;

  
  public boolean isCompact() {
    return compact;
  }

  public void setCompact(boolean compact) {
    this.compact = compact;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
  
  
  public int getLayers() {
    return layers;
  }
  
  public void setLayers(int layers) {
    this.layers = layers;
  }

 
  public int getCodeWords() {
    return codeWords;
  }

  public void setCodeWords(int codeWords) {
    this.codeWords = codeWords;
  }

  public BitMatrix getMatrix() {
    return matrix;
  }

  public void setMatrix(BitMatrix matrix) {
    this.matrix = matrix;
  }

}
