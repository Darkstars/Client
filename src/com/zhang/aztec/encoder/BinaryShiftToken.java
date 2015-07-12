

package com.zhang.aztec.encoder;

import com.zhang.common.BitArray;

final class BinaryShiftToken extends Token {
  
  private final short binaryShiftStart;
  private final short binaryShiftByteCount;
  
  BinaryShiftToken(Token previous,
                   int binaryShiftStart,
                   int binaryShiftByteCount) {
    super(previous);
    this.binaryShiftStart = (short) binaryShiftStart;
    this.binaryShiftByteCount = (short) binaryShiftByteCount;
  }

  @Override
  public void appendTo(BitArray bitArray, byte[] text) {
    for (int i = 0; i < binaryShiftByteCount; i++) {
      if (i == 0 || (i == 31 && binaryShiftByteCount <= 62))  {
     
        bitArray.appendBits(31, 5);  // BINARY_SHIFT
        if (binaryShiftByteCount > 62) {
          bitArray.appendBits(binaryShiftByteCount - 31, 16);
        } else if (i == 0) {
         
          bitArray.appendBits(Math.min(binaryShiftByteCount, 31), 5);
        } else {
         
          bitArray.appendBits(binaryShiftByteCount - 31, 5);
        }
      }
      bitArray.appendBits(text[binaryShiftStart + i], 8);
    }
  }

  @Override
  public String toString() {
    return "<" + binaryShiftStart + "::" + (binaryShiftStart + binaryShiftByteCount - 1) + '>';
  }

}
