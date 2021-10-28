package com.quantcast.most_active_cookie;

import com.quantcast.most_active_cookie.kernel.ICookieAnaExecutor;
import com.quantcast.most_active_cookie.kernel.CookieAnaExecutor;



public class MostActiveCookieApp {
	public static void main(String[] args) {
		ICookieAnaExecutor lAnaExecutor = new CookieAnaExecutor();
		lAnaExecutor.run(args);
	}
}
