package com.sudheer.vanhack.cs.miniurl.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author SUDHESHA
 *
 */
public class URLShortnerService {

	/**
	 * @param longurl
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws DataFormatException
	 */
	public static String getShortURL(String longurl) throws UnsupportedEncodingException, DataFormatException {
		String shortUrl = null; 
		
   	     String inputString = longurl;
   	     byte[] input = inputString.getBytes();
   	     // Compress the bytes
   	     byte[] output = new byte[100];
   	     Deflater compresser = new Deflater();
   	     compresser.setInput(input);
   	     compresser.finish();
   	     compresser.end();
   	       	      
   	     String o = output.toString();
   	     
   	     shortUrl = o;
	    
		return shortUrl;
	}
	
	/**
	 * @param shortURL
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws DataFormatException
	 */
	public static String getFullURL(String shortURL) throws UnsupportedEncodingException, DataFormatException {
		String fullUrl = null; 
		
  	     Inflater decompresser = new Inflater();
  	     byte[] input = new byte[100];
  	     
  	     decompresser.setInput(input, 0, Integer.parseInt(shortURL.toString().substring(shortURL.toString().length()-2)));
  	    
  	     decompresser.end();

  	     return fullUrl;
	}
	
	static Map<String,String> inMemoryMap ;
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		String url = null;
		
		String shortURL = null;
		inMemoryMap = new HashMap<>();
		
		url = "https://colinyeoh.wordpress.com/2014/02/28/parsing-json-data-using-google-gson-library-in-eclipse/";
		
		try {
			System.out.println("url -->"+url);
		
			shortURL = URLShortnerService.getShortURL(url);
			System.out.println("shortURL -->"+shortURL);
			
			inMemoryMap.put(shortURL, url);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
