package com.sudheer.vanhack.cs.miniurl.services;

import static spark.Spark.get;
import static spark.Spark.post;

import javax.persistence.EntityManager;

import com.sudheer.vanhack.cs.miniurl.urls.UrlMap;
import com.sudheer.vanhack.cs.miniurl.urls.UrlMapDAO;
import com.sudheer.vanhack.cs.miniurl.urls.UrlMapService;
import com.sudheer.vanhack.cs.miniurl.util.JPAUtil;
import com.sudheer.vanhack.cs.miniurl.util.JsonUtil;
import com.sudheer.vanhack.cs.miniurl.util.URLShortnerService;

/**
 * @author SUDHESHA
 *
 */
public class Main {

	public static void main(String[] args) {

		// test connection
		@SuppressWarnings("unused")
		EntityManager em = new JPAUtil().getEntityManager();

		// teste url http://localhost:4567/hello
		get("/hello", (req, res) -> "Hello - MiniURL microServices is up!!!");

		/*
		 * MINIURL MICROSERVICES
		 */
		get("/miniurl", (request, response) -> {
			System.out.println("Inside get/account");
			UrlMapDAO urlMapDao = new UrlMapDAO();
			System.out.println("query account ...");
			return JsonUtil.objToJson(urlMapDao.findAll());

		});

		get("/miniurl/:id", (request, response) -> {
			System.out.println("Inside /miniurl/:id");
			UrlMapDAO urlMapDao = new UrlMapDAO();
			System.out.println("query shorturl id is" + request.params("id"));
			return getHtml(urlMapDao.findByID(request.params("id")).getFullurl());
		});

		get("/miniurl/get/:id", (request, response) -> {
			System.out.println("Inside /miniurl/get/:id");
			UrlMapDAO urlMapDao = new UrlMapDAO();
			System.out.println("query shorturl id is" + request.params("id"));
			return JsonUtil.objToJson(urlMapDao.findByID(request.params("id")));
		});

		get("/getmini", (request, response) -> {
			System.out.println("Inside getmini");
			String retVal = "";
			try {
				retVal = getHtmlPostForm();
				return retVal;
			} catch (Exception e) {
				System.out.println("exception post => " + e.getMessage());
				return e.getMessage();
			}
		});

		post("/miniurl", (request, response) -> {
			System.out.println("Inside post/miniurl");
			StringBuilder retVal = new StringBuilder();
			try {
				System.out.println("request body => " + request.body());
				UrlMapService urlService = new UrlMapService();
				UrlMap[] urlMaps = urlService.jsonToUrlMap(request.body());

				for (UrlMap urlMap : urlMaps) {
					urlMap.setShotrurl(URLShortnerService.getShortURL(urlMap.getFullurl()));
					System.out.println("converted" + urlMap.toString());
					// save miniurl
					UrlMapDAO urlMapDao = new UrlMapDAO();
					urlMapDao.save(urlMap);

					retVal.append("http://localhost:4567/miniurl/"+urlMap.getShotrurl() + "\n");

				}
				System.out.println("url saved...");

				return retVal;
			} catch (Exception e) {
				System.out.println("exception post => " + e.getMessage());
				return e.getMessage();
			}
		});

		post("/getfromui", (request, response) -> {
			System.out.println("Inside getfromui");
			StringBuilder retVal = new StringBuilder();
			try {
				UrlMap urlMap = new UrlMap();

				urlMap.setFullurl(request.body().substring(0, request.body().indexOf("fullUrl=")));
				urlMap.setShotrurl(URLShortnerService.getShortURL(urlMap.getFullurl()));
				System.out.println("converted" + urlMap.toString());
				// save miniurl
				UrlMapDAO urlMapDao = new UrlMapDAO();
				urlMapDao.save(urlMap);

				retVal.append(urlMap.getShotrurl() + "\n");

				System.out.println("url saved...");

				return "Your short url is -->   " + "http://localhost:4567/miniurl/" + retVal;
			} catch (Exception e) {
				System.out.println("exception post => " + e.getMessage());
				return e.getMessage();
			}
		});

		post("/miniurlfull", (request, response) -> {
			System.out.println("Inside post/miniurl");
			try {
				System.out.println("request body => " + request.body());
				UrlMapService urlService = new UrlMapService();
				// String shortUrl = URLShortnerService.getShortURL(request.body().ge)
				UrlMap[] urlMaps = urlService.jsonToUrlMap(request.body());

				for (UrlMap urlMap : urlMaps) {
					urlMap.setShotrurl(URLShortnerService.getShortURL(urlMap.getFullurl()));
					UrlMapDAO urlMapDao = new UrlMapDAO();
					urlMapDao.save(urlMap);
					urlMap.setShotrurl("http://localhost:4567/miniurl/"+urlMap.getShotrurl());
				}
				System.out.println("url saved...");
				return JsonUtil.objToJson(urlMaps);
			} catch (Exception e) {
				System.out.println("exception post => " + e.getMessage());
				return e.getMessage();
			}
		});

	}

	/**
	 * @return
	 */
	private static String getHtmlPostForm() {
		// TODO Auto-generated method stub
		String retval = null;

		retval = "<!DOCTYPE html>" + "\n" + "<html>" + "\n" + "<body>" + "\n" + "<h2>Get a mini URL of your long URL</h2>" + "\n"
				+ "<form action=\"/getfromui\" method=\"post\">" + "\n" + "  Enter the full URL:<br>" + "\n"
				+ "  <input type=\"text\" name=\"fullUrl\" value=\"\">" + "\n" + "  <br>" + "\n"
				+ "  <input type=\"submit\" value=\"Submit\">" + "\n" + "</form>" + "\n" + "</body>" + "\n" + "</html>"
				+ "\n";

		return retval;
	}

	/**
	 * @param fullurl
	 * @return
	 */
	private static String getHtml(String fullurl) {
		String retHtml = null;

		retHtml = "<html>" + "\n" + "<head>" + "\n"
				+ "<title>A web page that points a browser to a different page after 2 seconds</title>" + "\n"
				+ "<meta http-equiv=\"refresh\" content=\"2; URL=" + fullurl + "\">" + "\n"
				+ "<meta name=\"keywords\" content=\"automatic redirection\">" + "\n" + "</head>" + "\n" + "<body>"
				+ "\n" + "If your browser doesn't automatically go there within a few seconds, " + "\n"
				+ "you may want to go to " + "\n" + "<a href=\"" + fullurl + "\">the destination</a> " + "\n"
				+ "manually." + "\n" + "</body>" + "\n" + "</html>" + "\n";

		return retHtml;
	}

}
