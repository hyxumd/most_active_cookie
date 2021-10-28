package com.quantcast.most_active_cookie.exceptions;

public class CookieServiceException extends Exception {
	public CookieServiceException(final Throwable cause) {
        super(cause);
    }
	public CookieServiceException(final String msg) {
        super(msg);
    }
	public CookieServiceException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
