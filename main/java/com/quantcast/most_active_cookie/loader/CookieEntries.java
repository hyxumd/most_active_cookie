package com.quantcast.most_active_cookie.loader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CookieEntries {
	private List<CookieEntry> mCookieEntryList;
	private LocalDate mDate;
	
	public CookieEntries() {
		mCookieEntryList = new ArrayList<>();
	}

	public List<CookieEntry> getCookieEntryList() {
		return mCookieEntryList;
	}

	public void addCookieEntry(CookieEntry iCookieEntry) {
		mCookieEntryList.add(iCookieEntry);
	}

	public LocalDate getDate() {
		return mDate;
	}

	public void setDate(LocalDate iDate) {
		this.mDate = iDate;
	}
	
	
}
