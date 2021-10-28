package com.quantcast.most_active_cookie.input;

import com.quantcast.most_active_cookie.exceptions.CookieServiceException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;

public class OptionsParser {
	private CommandLineOptions mCLOptions;
	
	public OptionsParser(final String[] args) throws CookieServiceException {
		mCLOptions = new CommandLineOptions();
		parseOptions(args);
	}
	
	private void parseOptions(final String[] args) throws CookieServiceException {
		parseFileName(args);
		parseDate(args);
	}
	
	public CommandLineOptions getCommandLineOptions() {
		return mCLOptions;
	}
	
	private void parseFileName(final String[] args) throws CookieServiceException{
		if(args == null || args.length < 1) {
			throw new CookieServiceException("File name is not specified.");
		}
		String lFileName = args[0];
		if(!isFileValid(lFileName)) {
			throw new CookieServiceException("File name is not valid.");
		}
		mCLOptions.setFileName(lFileName);
	}
	
	private void parseDate(final String[] args) throws CookieServiceException {
		if(args == null || args.length < 3) {
			throw new CookieServiceException("Date is not Specified.");
		}
		if(!args[1].equals("-d")) {
			throw new CookieServiceException("Date option is not valid.");
		}
		String lDate = args[2];
		if(!isDateValid(lDate)) {
			throw new CookieServiceException("Date is not valid.");
		}
		
		mCLOptions.setDate(LocalDate.parse(lDate));
		
	}
	
	private boolean isFileValid(final String iFilename) {
		File file = new File(iFilename);
	    return file.exists() && file.isFile();
	}
	
	private boolean isDateValid(final String iDate) {
	    DateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    lDateFormat.setLenient(false);
	    try {
	    	lDateFormat.parse(iDate);
	    } catch (ParseException e) {
	      return false;
	    }
	    return true;
	  }
}
