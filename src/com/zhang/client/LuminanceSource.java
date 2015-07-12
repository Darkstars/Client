package com.zhang.client;

/**
 * 
 * 
 * @author �ź��
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
	 * ��һ�ž���ת����Ϊ���ݾ����ͼƬ�л�ȡһ�е�����
	 */
	public abstract byte[] getRow(int y, byte[] row);

	/*
	 * �õ�ͼƬ�����ݾ���
	 */
	public abstract byte[] getMatrix();

	/*
	 * ��ȡͼƬ�Ŀ��
	 */
	public final int getWidth() {
		return width;
	}

	/*
	 * ��ȡͼƬ�ĸ߶�
	 */

	public final int getHeight() {
		return height;
	}

	/*
	 * �ж�ͼƬ�Ƿ�֧�ּ���
	 */

	public boolean isCropSupported() {
		return false;
	}

	/*
	 * ����ͼƬ
	 */

	public LuminanceSource crop(int left, int top, int width, int height) {
		throw new UnsupportedOperationException("���ƽ��ͼƬ��֧���и�.");
	}

	/*
	 * �ж�һ��ͼƬ�Ƿ�֧����ת
	 */

	public boolean isRotateSupported() {
		return false;
	}

	public LuminanceSource invert() {
		return new InvertedLuminanceSource(this);
	}

	/*
	 * ��תͼƬ
	 */

	public LuminanceSource rotateCounterClockwise() {
		throw new UnsupportedOperationException(
				"This luminance source does not support rotation by 90 degrees.");
	}

	public LuminanceSource rotateCounterClockwise45() {
		throw new UnsupportedOperationException("����ͼƬ֧��45����ת");
	}

	/*
	 * ��ͼƬ�Ĳ�����Ϊ�ַ���
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
