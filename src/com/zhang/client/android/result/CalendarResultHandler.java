package com.zhang.client.android.result;

import android.content.ActivityNotFoundException;
import android.util.Log;

import com.google.zxing.client.android.R;
import com.zhang.client.result.CalendarParsedResult;
import com.zhang.client.result.ParsedResult;

import android.app.Activity;
import android.content.Intent;

import java.text.DateFormat;
import java.util.Date;

public final class CalendarResultHandler extends ResultHandler {

	private static final String TAG = CalendarResultHandler.class
			.getSimpleName();

	private static final int[] buttons = { R.string.button_add_calendar };

	public CalendarResultHandler(Activity activity, ParsedResult result) {
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
		if (index == 0) {
			CalendarParsedResult calendarResult = (CalendarParsedResult) getResult();

			String description = calendarResult.getDescription();
			String organizer = calendarResult.getOrganizer();
			if (organizer != null) { // No separate Intent key, put in
										// description
				if (description == null) {
					description = organizer;
				} else {
					description = description + '\n' + organizer;
				}
			}

			addCalendarEvent(calendarResult.getSummary(),
					calendarResult.getStart(), calendarResult.isStartAllDay(),
					calendarResult.getEnd(), calendarResult.getLocation(),
					description, calendarResult.getAttendees());
		}
	}

	private void addCalendarEvent(String summary, Date start, boolean allDay,
			Date end, String location, String description, String[] attendees) {
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType("vnd.android.cursor.item/event");
		long startMilliseconds = start.getTime();
		intent.putExtra("beginTime", startMilliseconds);
		if (allDay) {
			intent.putExtra("allDay", true);
		}
		long endMilliseconds;
		if (end == null) {
			if (allDay) {
				// + 1 day
				endMilliseconds = startMilliseconds + 24 * 60 * 60 * 1000;
			} else {
				endMilliseconds = startMilliseconds;
			}
		} else {
			endMilliseconds = end.getTime();
		}
		intent.putExtra("endTime", endMilliseconds);
		intent.putExtra("title", summary);
		intent.putExtra("eventLocation", location);
		intent.putExtra("description", description);
		if (attendees != null) {
			intent.putExtra(Intent.EXTRA_EMAIL, attendees);
			// Documentation says this is either a String[] or comma-separated
			// String, which is right?
		}

		try {
			// Do this manually at first
			rawLaunchIntent(intent);
		} catch (ActivityNotFoundException anfe) {
			Log.w(TAG, "No calendar app available that responds to "
					+ Intent.ACTION_INSERT);
			// For calendar apps that don't like "INSERT":
			intent.setAction(Intent.ACTION_EDIT);
			launchIntent(intent); // Fail here for real if nothing can handle it
		}
	}

	@Override
	public CharSequence getDisplayContents() {

		CalendarParsedResult calResult = (CalendarParsedResult) getResult();
		StringBuilder result = new StringBuilder(100);

		ParsedResult.maybeAppend(calResult.getSummary(), result);

		Date start = calResult.getStart();
		ParsedResult.maybeAppend(format(calResult.isStartAllDay(), start),
				result);

		Date end = calResult.getEnd();
		if (end != null) {
			if (calResult.isEndAllDay() && !start.equals(end)) {

				end = new Date(end.getTime() - 24 * 60 * 60 * 1000);
			}
			ParsedResult.maybeAppend(format(calResult.isEndAllDay(), end),
					result);
		}

		ParsedResult.maybeAppend(calResult.getLocation(), result);
		ParsedResult.maybeAppend(calResult.getOrganizer(), result);
		ParsedResult.maybeAppend(calResult.getAttendees(), result);
		ParsedResult.maybeAppend(calResult.getDescription(), result);
		return result.toString();
	}

	private static String format(boolean allDay, Date date) {
		if (date == null) {
			return null;
		}
		DateFormat format = allDay ? DateFormat
				.getDateInstance(DateFormat.MEDIUM) : DateFormat
				.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		return format.format(date);
	}

	@Override
	public int getDisplayTitle() {
		return R.string.result_calendar;
	}
}
