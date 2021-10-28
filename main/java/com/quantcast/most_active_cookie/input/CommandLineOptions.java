package com.quantcast.most_active_cookie.input;

import java.time.LocalDate;

public class CommandLineOptions {
	private String mFileName;
	private LocalDate mDate;
	
	public CommandLineOptions() {
		
	}
	
	public CommandLineOptions(String iFileName, LocalDate iDate) {
		this.mFileName = iFileName;
		this.mDate = iDate;
	}

	public String getFileName() {
		return mFileName;
	}

	public void setFileName(String iFileName) {
		this.mFileName = iFileName;
	}

	public LocalDate getDate() {
		return mDate;
	}

	public void setDate(LocalDate iDate) {
		this.mDate = iDate;
	}
}
