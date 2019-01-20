package com.sudheer.vanhack.cs.miniurl.urls;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SUDHESHA
 *
 */
public class UrlMapService {

	/**
	 * @param urlMapJson
	 * @return
	 * @throws IOException
	 */
	public UrlMap[] jsonToUrlMap(String urlMapJson) throws IOException {
		System.out.println("Inside UrlMapService.jsonToURLMap");
		ObjectMapper mapper = new ObjectMapper();
//		UrlMap urlMap = mapper.readValue(urlMapJson, UrlMap.class);
		UrlMap[] urlMaps = mapper.readValue(urlMapJson, UrlMap[].class); 
		return urlMaps;
	}
}
