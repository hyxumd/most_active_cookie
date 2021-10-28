package com.quantcast.most_active_cookie.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.quantcast.most_active_cookie.loader.CookieEntries;
import com.quantcast.most_active_cookie.loader.CookieEntry;

public class CookieStatTest {
	@Test
	public void getMostActiveCookiesTest() {
		CookieEntries lCookieEntries = new CookieEntries();
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie1", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie2", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie2", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie1", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie3", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie4", null));
		lCookieEntries.addCookieEntry(new CookieEntry("Cookie5", null));
		
		ICookieStat lCookieStat = new CookieStat();
		List<String> lMostActiveCookies = lCookieStat.getMostActiveCookies(lCookieEntries);
		assertEquals(2, lMostActiveCookies.size());
		assertTrue(lMostActiveCookies.contains("Cookie1"));
		assertTrue(lMostActiveCookies.contains("Cookie2"));
	}
	
}
