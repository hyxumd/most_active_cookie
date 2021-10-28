package com.quantcast.most_active_cookie.engine;

import java.util.List;

import com.quantcast.most_active_cookie.loader.CookieEntries;

public interface ICookieStat {
	List<String> getMostActiveCookies(CookieEntries iCookieEntries);
}
