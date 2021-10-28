package com.quantcast.most_active_cookie.loader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.quantcast.most_active_cookie.exceptions.CookieServiceException;
import com.quantcast.most_active_cookie.input.CommandLineOptions;
import com.quantcast.most_active_cookie.input.OptionsParser;

public class FileLoaderTest {
	@Test
	public void LoadCookiesFromBrokenFile() throws CookieServiceException {
		// broken_cookie_log.csv has invalid format, expect to throw CookieServiceException
		String[] lArgs= new String[] {"src/test/resources/broken_cookie_log.csv", "-d", "2018-12-09"};
		OptionsParser lOP = new OptionsParser(lArgs);
		CommandLineOptions lCmdLineOptions = lOP.getCommandLineOptions();
		CookieServiceException exp = 
				assertThrows(CookieServiceException.class, () -> new FileLoader(lCmdLineOptions));
	}
	
	@Test
	public void LoadCookiesFromValidFile() throws CookieServiceException {
		String[] lArgs= new String[] {"src/test/resources/cookie_log.csv", "-d", "2018-12-09"};
		OptionsParser lOP = new OptionsParser(lArgs);
		CommandLineOptions lCmdLineOptions = lOP.getCommandLineOptions();
		FileLoader lFilerLoader = new FileLoader(lCmdLineOptions);
		CookieEntries lCookieEntries = lFilerLoader.getCookieEntries();
		assertNotNull(lCookieEntries);
		assertNotNull(lCookieEntries.getDate());
		// Check lCookieEntries.mDate is expected
		assertEquals(LocalDate.parse(lArgs[2]), lCookieEntries.getDate());
		
		List<CookieEntry> lCookieEntryList = lCookieEntries.getCookieEntryList();
		assertNotNull(lCookieEntryList);
		// expect matched cookie list has 5 entries
		assertEquals(5, lCookieEntryList.size());
	}
}
