package com.sudheer.vanhack.cs.miniurl.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.sudheer.vanhack.cs.miniurl.builder.UrlMapBuilder;
import com.sudheer.vanhack.cs.miniurl.urls.UrlMap;
import com.sudheer.vanhack.cs.miniurl.urls.UrlMapDAO;

public class BasicTests {

	BigDecimal customerBalance = BigDecimal.ZERO;

	@Before
	public void cleanOldTests() {
		System.out.println("Cleaning previous tests...");
		// clean accounts
		UrlMapDAO urlMapDAO = new UrlMapDAO();
		UrlMap urlMap  = urlMapDAO.findByID("[B@8b99874");
		urlMapDAO.delete(urlMap);
		
		System.out.println("End of cleaning previous tests...");
	}
	
	

	@Test
	public void insertMiniURL() {

		// create customer
				// create accounts
		UrlMap urlMap1 = UrlMapBuilder.buildAccount();
		urlMap1.setShotrurl("[B@8b99874");
		urlMap1.setFullurl("http://google.com");
		
		UrlMap urlMap2 = UrlMapBuilder.buildAccount();
		urlMap2.setShotrurl("[B@5dd80c14");
		urlMap2.setFullurl("http://yahoo.com/");
		
		// persist
		UrlMapDAO urlMapDAO = new UrlMapDAO();
		urlMapDAO.save(urlMap1);
		urlMapDAO.save(urlMap2);

		// check sum of inserted accounts
	}

	
}
