# vanhackcs
Repo for vanhack code hack

If there is need to deploy application on differnet folder all that needs to be done is to
copy the files under miniurl\dist to a folder of your choice and then 
to Launch the application use Miniurlservicelauncher.sh on LINUX and Miniurlservicelauncher.bat on windows.
If My SQL port is differnet please change the persistance.xml (located under MiniURLService.jar/META-INF) accordingly.
Docker: Configuration is available under Dockerfile
https://cloud.docker.com/repository/docker/sudheer316/sudheer

Once the application is launched below API/services can be used.
By default the application runs on port 4567 . 

On a localmachine URL will be http://localhost:4567/

/hello	 returns "Hello - MiniURL microServices is up!!!" is service is up

GET
/miniurl  -- Returns everything
/miniurl/:id  -- returns HTML with auto redirection to the full url
/miniurl/get/:id  -- return full JSON , { "shotrurl" : "[B@2c8399d0", "fullurl" : "http://www.google.com", "createdOn" : "2019-01-19", "id" : 25 }
/getmini Has a HTML form to get the miniurl

POST
/getfromui - used to get the request from UI

/miniurl  --To Post a fullURL and it will return the short version retruns only the URL
REQUEST:::
 [{
  "fullurl" : "http://www.google.com"
 },
 {
  "fullurl" : "http://www.yahoo.com"
 }
 ]
 Response:::
http://localhost:4567/miniurl/[B@50edbb5d
http://localhost:4567/miniurl/[B@2e422a5b

/miniurlfull --To Post a fullURL and it will return the short version retruns JSON, but shorturl will be with full context
REQUEST:::
 [{
  "fullurl" : "http://www.google.com"
 },
 {
  "fullurl" : "http://www.yahoo.com"
 }
 ]
Response::: 
[ {
  "shotrurl" : "http://localhost:4567/miniurl/[B@17b0a7e6",
  "fullurl" : "http://www.google.com",
  "createdOn" : "2019-01-20",
  "id" : 36
}, {
  "shotrurl" : "http://localhost:4567/miniurl/[B@5dd80c14",
  "fullurl" : "http://www.yahoo.com",
  "createdOn" : "2019-01-20",
  "id" : 37
} ]

-------------------------------------------------------------------------------------------------------------------------------------
Mini URL Services
1.	Environment Setup
2.	Importing the code
3.	Building the code
4.	Testing
5.	Docker

1.	Environment Setup
Softwares needed 
	OS : Windows 7 or Higher/Linux/Mac OS
	Editor : Eclipse (preferred), Net Beans etc
	Tools : ORACLE JAVA 8  or Open JDK, MySql 8
2.	Importing the code . 
Unzip the MIniURLServices.zip into a folder of your choice. Use the import wizard in the IDE to get the code . Use a Maven Project to import.
3.	Building the code :  Use the Maven build, Ex: in Eclipse go to project (right click) select Maven and update the maven , to save time set Build automatically .
              MySQL server 8, default user is root and password is admin123
	      
4.	Testing 
Application can be run as simple java application , the default port it uses is 4567
Use in the browser : http://localhost:4567/hello 
The must return ; Hello - MiniURL microServices is up!!!
 
Code Explained:
Main.java . Has all the get and post methods
 

UrlMap.java has ORM
UrlMapDAO is data access object have methods to save and retrive
UrlMapService provides method to convert json to object.

JPAUtil is the JPA persistence manager, gets conf from persistence.xml
JsonUtil is for processing json
URLShortnerService this the class that will shorten the URL. It applies standard JAVA string compression .
getShortURL takes full URL and returns the short URL
Persistence XML has the persistence configuration:

Basictests.java has some basic tests
 
Docker: Configuration is available under Dockerfile

