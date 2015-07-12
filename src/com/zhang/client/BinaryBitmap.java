package com.zhang.client;

import com.zhang.common.BitArray;
import com.zhang.common.BitMatrix;

/**
 * 这个类是bitmap类的核心，代表ibit的数据
 * 
 * @author 张洪斌
 */
public final class BinaryBitmap {

	private final Binarizer binarizer;
	private BitMatrix matrix;

	public BinaryBitmap(Binarizer binarizer) {
		if (binarizer == null) {
			throw new IllegalArgumentException("Binarizer 不能为空");
		}
		this.binarizer = binarizer;
	}

	/**
	 * @return bitmap的宽度
	 */
	public int getWidth() {
		return binarizer.getWidth();
	}

	/**
	 * @return bitmap的高度.
	 */
	public int getHeight() {
		return binarizer.getHeight();
	}

	public BitArray getBlackRow(int y, BitArray row) throws NotFoundException {
		return binarizer.getBlackRow(y, row);
	}

	public BitMatrix getBlackMatrix() throws NotFoundException {

		if (matrix == null) {
			matrix = binarizer.getBlackMatrix();
		}
		return matrix;
	}

	/**
	 * @return 能被剪切的图片的宽度
	 * 
	 **/
	public boolean isCropSupported() {
		return binarizer.getLuminanceSource().isCropSupported();
	}

	public BinaryBitmap crop(int left, int top, int width, int height) {
		LuminanceSource newSource = binarizer.getLuminanceSource().crop(left,
				top, width, height);
		return new BinaryBitmap(binarizer.createBinarizer(newSource));
	}

	public boolean isRotateSupported() {
		return binarizer.getLuminanceSource().isRotateSupported();
	}

	public BinaryBitmap rotateCounterClockwise45() {
		LuminanceSource newSource = binarizer.getLuminanceSource()
				.rotateCounterClockwise45();
		return new BinaryBitmap(binarizer.createBinarizer(newSource));
	}

	public BinaryBitmap rotateCounterClockwise() {
		
		return null;
	}

}
