package com.quantcast.most_active_cookie.kernel;

import java.util.List;

import com.quantcast.most_active_cookie.engine.CookieStat;
import com.quantcast.most_active_cookie.engine.ICookieStat;
import com.quantcast.most_active_cookie.exceptions.CookieServiceException;
import com.quantcast.most_active_cookie.input.CommandLineOptions;
import com.quantcast.most_active_cookie.input.OptionsParser;
import com.quantcast.most_active_cookie.loader.CookieEntries;
import com.quantcast.most_active_cookie.loader.FileLoader;

public class CookieAnaExecutor implements ICookieAnaExecutor {
	public void run(final String[] args) {
		try {
			OptionsParser lOP = new OptionsParser(args);
			CommandLineOptions lCmdLineOptions = lOP.getCommandLineOptions();
			FileLoader lFilerLoader = new FileLoader(lCmdLineOptions);
			CookieEntries lCookieEntries = lFilerLoader.getCookieEntries();
			ICookieStat lCookieStat = new CookieStat();
			List<String> lStrs = lCookieStat.getMostActiveCookies(lCookieEntries);
			if(lStrs.isEmpty()) {
				System.out.println("There are no cookes at the specified date");
				return;
			}
			for(String lCookie : lStrs) {
				System.out.println(lCookie);
			}
		} catch (CookieServiceException | RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
