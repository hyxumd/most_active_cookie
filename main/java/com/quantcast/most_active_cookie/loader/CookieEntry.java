package com.quantcast.most_active_cookie.loader;

import java.time.ZonedDateTime;

public class CookieEntry {
	private String mCookie;
	private ZonedDateTime mDateTime;
	
	public CookieEntry() {
		
	}

	public CookieEntry(String iCookie, ZonedDateTime iDateTime) {
		this.mCookie = iCookie;
		this.mDateTime = iDateTime;
	}

	public String getCookie() {
		return mCookie;
	}

	public ZonedDateTime getDateTime() {
		return mDateTime;
	}
}
