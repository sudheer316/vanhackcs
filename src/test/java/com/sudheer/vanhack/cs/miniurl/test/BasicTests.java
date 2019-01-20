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
		UrlMap urlMap  = urlMapDAO.findByID("ACC001");
		urlMapDAO.delete(urlMap);
		
		System.out.println("End of cleaning previous tests...");
	}
	
	

	@Test
	public void insertMiniURL() {

		// create customer
				// create accounts
		UrlMap urlMap1 = UrlMapBuilder.buildAccount();
		urlMap1.setShotrurl("ACC001");
		urlMap1.setFullurl("http://google.com");
		
		UrlMap urlMap2 = UrlMapBuilder.buildAccount();
		urlMap2.setShotrurl("ACC002");
		urlMap2.setFullurl("http://google.com/2");
		
		// persist
		UrlMapDAO urlMapDAO = new UrlMapDAO();
		urlMapDAO.save(urlMap1);
		urlMapDAO.save(urlMap2);

		// check sum of inserted accounts
	}

	
}
