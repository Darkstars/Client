package com.zhang.client.android.result;

import com.google.zxing.client.android.R;
import com.zhang.client.result.ParsedResult;
import com.zhang.client.result.SMSParsedResult;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;

public final class SMSResultHandler extends ResultHandler {
	private static final int[] buttons = { R.string.button_sms,
			R.string.button_mms };

	public SMSResultHandler(Activity activity, ParsedResult result) {
		super(activity, result);
	}

	@Override
	public int getButtonCount() {
		return buttons.length;
	}

	@Override
	public int getButtonText(int index) {
		return buttons[index];
	}

	@Override
	public void handleButtonPress(int index) {
		SMSParsedResult smsResult = (SMSParsedResult) getResult();
		switch (index) {
		case 0:
			// Don't know of a way yet to express a SENDTO intent with multiple
			// recipients
			sendSMS(smsResult.getNumbers()[0], smsResult.getBody());
			break;
		case 1:
			sendMMS(smsResult.getNumbers()[0], smsResult.getSubject(),
					smsResult.getBody());
			break;
		}
	}

	@Override
	public CharSequence getDisplayContents() {
		SMSParsedResult smsResult = (SMSParsedResult) getResult();
		String[] rawNumbers = smsResult.getNumbers();
		String[] formattedNumbers = new String[rawNumbers.length];
		for (int i = 0; i < rawNumbers.length; i++) {
			formattedNumbers[i] = PhoneNumberUtils.formatNumber(rawNumbers[i]);
		}
		StringBuilder contents = new StringBuilder(50);
		ParsedResult.maybeAppend(formattedNumbers, contents);
		ParsedResult.maybeAppend(smsResult.getSubject(), contents);
		ParsedResult.maybeAppend(smsResult.getBody(), contents);
		return contents.toString();
	}

	@Override
	public int getDisplayTitle() {
		return R.string.result_sms;
	}
}
