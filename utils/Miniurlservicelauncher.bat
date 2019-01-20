echo "MINIURL MICROSERVICE LAUNCHER"

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/antlr-2.7.7.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/byte-buddy-1.8.17.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/classmate-1.3.4.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/dom4j-2.1.1.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/hibernate-commons-annotations-5.0.4.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/hibernate-core-5.3.7.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/hibernate-entitymanager-5.3.7.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/hibernate-jpa-2.1-api-1.0.2.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jackson-annotations-2.6.0.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jackson-core-2.6.3.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jackson-databind-2.6.3.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jandex-2.0.5.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/javassist-3.23.1-GA.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/javax.activation-api-1.2.0.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/javax.persistence-api-2.2.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/javax.servlet-api-3.1.0.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jboss-logging-3.3.2.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jboss-transaction-api_1.2_spec-1.1.1.Final.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-http-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-io-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-security-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-server-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-servlet-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-util-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-webapp-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/jetty-xml-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/mysql-connector-java-8.0.11.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/protobuf-java-2.6.0.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/slf4j-api-1.7.13.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/spark-core-2.5.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/websocket-api-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/websocket-client-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/websocket-common-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/websocket-server-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService_lib/websocket-servlet-9.3.6.v20151106.jar
set CLASSPATH=%CLASSPATH%;./MiniURLService.jar

echo %CLASSPATH%

echo %JAVA_HOME%

SET MINIRUL_MS_HOME="."

"java" -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n -server -Dminiurlserver.home=${MINIRUL_MS_HOME} -Djava.awt.headless=true  com.sudheer.vanhack.cs.miniurl.services.Main
pause