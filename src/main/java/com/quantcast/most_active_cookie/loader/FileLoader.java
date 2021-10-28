package com.quantcast.most_active_cookie.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.quantcast.most_active_cookie.exceptions.CookieServiceException;
import com.quantcast.most_active_cookie.input.CommandLineOptions;

public class FileLoader {
	private static final String COMMA_DELIMITER = ",";
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX";
	private CookieEntries mCookieEntries;
	
	public FileLoader(CommandLineOptions iCLOptions) throws CookieServiceException {
		mCookieEntries = new CookieEntries();
		mCookieEntries.setDate(iCLOptions.getDate());
		LoadCookies(iCLOptions.getFileName(), iCLOptions.getDate());
	}
	
	public void LoadCookies(final String iFileName, final LocalDate iDate) throws CookieServiceException {
		DateTimeFormatter lDTFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		final ZoneId lUtcZone = ZoneId.of("UTC");
	    final ZonedDateTime lStartTime = iDate.atStartOfDay(lUtcZone);
	    final ZonedDateTime lEndTime = iDate.atStartOfDay(lUtcZone).plusDays(1);
		try (BufferedReader lBr = new BufferedReader(new FileReader(iFileName))) {
			lBr.readLine();
			String lCurLine;
		    while ((lCurLine = lBr.readLine()) != null) {
		        String[] lEntries = lCurLine.split(COMMA_DELIMITER);
		        if(lEntries == null || lEntries.length != 2) {
		        	
		        }
		        String lDTStr = lEntries[1];
		        ZonedDateTime lCurDT = ZonedDateTime.parse(lDTStr, lDTFormatter);
		        if(lStartTime.compareTo(lCurDT) > 0 || lEndTime.compareTo(lCurDT) <= 0) {
		        	continue;
		        }
		        CookieEntry lCookEntry = new CookieEntry(lEntries[0], lCurDT);
		        mCookieEntries.addCookieEntry(lCookEntry);
		    }
		} catch (Exception e) {
	        String lMsg = e.getMessage();
	        if(!lMsg.isEmpty()) {
	        	lMsg += '\n';
	        }
	        lMsg += iFileName;
	        lMsg += " cannot be parsed. Please check the data integrity in the file.";
	        throw new CookieServiceException(lMsg);
	    }
	}
	
	public CookieEntries getCookieEntries() {
		return mCookieEntries;
	}
}
