package com.sudheer.vanhack.cs.miniurl.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SUDHESHA
 *
 */
public class JsonUtil {

	// Convert object to JSON string and pretty print
	/**
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		return jsonInString;
	}
	
	// Convert object to JSON string and pretty print
	/**
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objToJson(Object[] object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		return jsonInString;
	}
}
