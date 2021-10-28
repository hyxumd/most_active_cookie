package com.quantcast.most_active_cookie.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quantcast.most_active_cookie.loader.CookieEntries;
import com.quantcast.most_active_cookie.loader.CookieEntry;

public class CookieStat implements ICookieStat {
	public List<String> getMostActiveCookies(CookieEntries iCookieEntries) {
		List<String> lRes = new ArrayList<>();
		Integer lMaxFreq = 0;
		Map<String, Integer> lCookie2Freq = new HashMap<>();
		List<CookieEntry> lCookieEntryList = iCookieEntries.getCookieEntryList();
		for(CookieEntry lCookieEntry : lCookieEntryList) {
			String lCurCookie = lCookieEntry.getCookie();
			Integer lFreq = lCookie2Freq.getOrDefault(lCurCookie, 0);
			lFreq++;
			lCookie2Freq.put(lCurCookie, lFreq);
			
			if(lFreq > lMaxFreq) {
				lMaxFreq = lFreq;
				lRes.clear();
				lRes.add(lCurCookie);
			}
			else if (lFreq == lMaxFreq) {
				lRes.add(lCurCookie);
			}
		}
		return lRes;
	}
	
}
