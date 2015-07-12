package com.zhang.client.android.result;

import com.google.zxing.client.android.R;
import com.zhang.client.result.ParsedResult;
import com.zhang.client.result.TelParsedResult;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;

public final class TelResultHandler extends ResultHandler {
	private static final int[] buttons = { R.string.button_dial,
			R.string.button_add_contact };

	public TelResultHandler(Activity activity, ParsedResult result) {
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
		TelParsedResult telResult = (TelParsedResult) getResult();
		switch (index) {
		case 0:
			dialPhoneFromUri(telResult.getTelURI());

			getActivity().finish();
			break;
		case 1:
			String[] numbers = new String[1];
			numbers[0] = telResult.getNumber();
			addPhoneOnlyContact(numbers, null);
			break;
		}
	}

	@Override
	public CharSequence getDisplayContents() {
		String contents = getResult().getDisplayResult();
		contents = contents.replace("\r", "");
		return PhoneNumberUtils.formatNumber(contents);
	}

	@Override
	public int getDisplayTitle() {
		return R.string.result_tel;
	}
}
