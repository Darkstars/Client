package com.zhang.client;

/**
 * 
 * 
 * @author 张洪斌
 */
public abstract class LuminanceSource {

	private final int width;
	private final int height;

	protected LuminanceSource(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/*
	 * 
	 * 从一张经过转换成为数据矩阵的图片中获取一行的数据
	 */
	public abstract byte[] getRow(int y, byte[] row);

	/*
	 * 得到图片的数据矩阵
	 */
	public abstract byte[] getMatrix();

	/*
	 * 获取图片的宽度
	 */
	public final int getWidth() {
		return width;
	}

	/*
	 * 获取图片的高度
	 */

	public final int getHeight() {
		return height;
	}

	/*
	 * 判断图片是否支持剪切
	 */

	public boolean isCropSupported() {
		return false;
	}

	/*
	 * 剪切图片
	 */

	public LuminanceSource crop(int left, int top, int width, int height) {
		throw new UnsupportedOperationException("这个平面图片不支持切割.");
	}

	/*
	 * 判断一张图片是否支持旋转
	 */

	public boolean isRotateSupported() {
		return false;
	}

	public LuminanceSource invert() {
		return new InvertedLuminanceSource(this);
	}

	/*
	 * 反转图片
	 */

	public LuminanceSource rotateCounterClockwise() {
		throw new UnsupportedOperationException(
				"This luminance source does not support rotation by 90 degrees.");
	}

	public LuminanceSource rotateCounterClockwise45() {
		throw new UnsupportedOperationException("这张图片支持45度旋转");
	}

	/*
	 * 把图片的参数换为字符串
	 */

	@Override
	public final String toString() {
		byte[] row = new byte[width];
		StringBuilder result = new StringBuilder(height * (width + 1));
		for (int y = 0; y < height; y++) {
			row = getRow(y, row);
			for (int x = 0; x < width; x++) {
				int luminance = row[x] & 0xFF;
				char c;
				if (luminance < 0x40) {
					c = '#';
				} else if (luminance < 0x80) {
					c = '+';
				} else if (luminance < 0xC0) {
					c = '.';
				} else {
					c = ' ';
				}
				result.append(c);
			}
			result.append('\n');
		}
		return result.toString();
	}

}
