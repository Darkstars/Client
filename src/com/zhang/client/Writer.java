package com.zhang.client;

import com.zhang.common.BitMatrix;

import java.util.Map;

public interface Writer {

	BitMatrix encode(String contents, BarcodeFormat format, int width,
			int height) throws WriterException;

	BitMatrix encode(String contents, BarcodeFormat format, int width,
			int height, Map<EncodeHintType, ?> hints) throws WriterException;

}
