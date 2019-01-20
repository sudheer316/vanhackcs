package com.sudheer.vanhack.cs.miniurl.builder;

import com.sudheer.vanhack.cs.miniurl.urls.UrlMap;

public class UrlMapBuilder {
	
	public static UrlMap buildAccount() {
		
		UrlMap urlMap = new UrlMap();
		urlMap.setShotrurl("ACC001");
		urlMap.setFullurl("http://google.com");
		return urlMap;
	}

}
