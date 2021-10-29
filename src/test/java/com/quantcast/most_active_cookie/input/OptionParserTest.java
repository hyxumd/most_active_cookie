package com.quantcast.most_active_cookie.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.Test;

import com.quantcast.most_active_cookie.exceptions.CookieServiceException;

public class OptionParserTest {
	@Test
	public void exceptionThrownForInvalidInput() {
		CookieServiceException exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(null));
		assertEquals(
				"Command line options are invalid.", exp.getMessage());
		
		String[] lSingleOption = new String[] {"fake_log10272021.csv"};
		exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lSingleOption));
		assertEquals(
				"Command line options are invalid.", exp.getMessage());
		
		String[] lTooManyOptions = new String[] {"fake_log10272021.csv", "-d", "2018-12-09", "2000"};
		exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lTooManyOptions));
		assertEquals(
				"Command line options are invalid.", exp.getMessage());
	}
	
	@Test
	public void exceptionThrownForIllegalFileName() {
		String[] lNotAFile = new String[] {"/", "-d", "2018-12-09"};
		CookieServiceException exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lNotAFile));
		assertEquals(
				"File name is not valid.", exp.getMessage());
		
		String[] lNonExistFile = new String[] {"fake_log10272021.csv", "-d", "2018-12-09"};
		exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lNonExistFile));
		assertEquals(
				"File name is not valid.", exp.getMessage());
	}
	
	@Test
	public void exceptionThrownForIllegalDate() {
		String[] lWrongOption = new String[] {"src/test/resources/cookie_log.csv", "-D", "2018-12-09"};
		CookieServiceException exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lWrongOption));
		assertEquals(
				"Date option is not valid.", exp.getMessage());
		
		String[] lMissingPart = new String[] {"src/test/resources/cookie_log.csv", "-d", "2018-12"};
		exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lMissingPart));
		assertEquals(
				"Date is not valid.", exp.getMessage());
		
		String[] lInValidDate = new String[] {"src/test/resources/cookie_log.csv", "-d", "2018-12-32"};
		exp = 
				assertThrows(CookieServiceException.class, () -> new OptionsParser(lInValidDate));
		assertEquals(
				"Date is not valid.", exp.getMessage());
	}
	
	@Test
	public void parseValidFileNameAndDate() throws CookieServiceException {
		String[] lArgs= new String[] {"src/test/resources/cookie_log.csv", "-d", "2018-12-10"};
		OptionsParser lOP = new OptionsParser(lArgs);
		CommandLineOptions lCmdLineOptions = lOP.getCommandLineOptions();
		assertNotNull(lCmdLineOptions);
		// check parsed filename and date is expected
		assertEquals(lArgs[0], lCmdLineOptions.getFileName());
		assertEquals(LocalDate.parse(lArgs[2]), lCmdLineOptions.getDate());
	}
	
	
}
