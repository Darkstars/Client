package com.zhang.client.android.history;

import com.zhang.client.Result;

public final class HistoryItem {

	private final Result result;
	private final String display;
	private final String details;

	HistoryItem(Result result, String display, String details) {
		this.result = result;
		this.display = display;
		this.details = details;
	}

	public Result getResult() {
		return result;
	}

	public String getDisplayAndDetails() {
		StringBuilder displayResult = new StringBuilder();
		if (display == null || display.isEmpty()) {
			displayResult.append(result.getText());
		} else {
			displayResult.append(display);
		}
		if (details != null && !details.isEmpty()) {
			displayResult.append(" : ").append(details);
		}
		return displayResult.toString();
	}

}
