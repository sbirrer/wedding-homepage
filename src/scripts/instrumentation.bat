md target\activejdbc-instrumentation

set CLASSPATH=C:\Users\sbirr\.m2\repository\org\javalite\activejdbc\2.2\activejdbc-2.2.jar
set CLASSPATH=%CLASSPATH%;C:\Users\sbirr\.m2\repository\org\javalite\javalite-common\2.2\javalite-common-2.2.jar
set CLASSPATH=%CLASSPATH%;C:\Users\sbirr\.m2\repository\mysql\mysql-connector-java\8.0.12\mysql-connector-java-8.0.12.jar
set CLASSPATH=%CLASSPATH%;C:\Users\sbirr\.m2\repository\org\slf4j\slf4j-api\1.7.0\slf4j-api-1.7.0.jar
set CLASSPATH=%CLASSPATH%;C:\Users\sbirr\.m2\repository\org\slf4j\slf4j-simple\1.7.5\slf4j-simple-1.7.5.jar
set CLASSPATH=%CLASSPATH%;C:\Users\sbirr\.m2\repository\org\javalite\activejdbc-instrumentation\2.2\activejdbc-instrumentation-2.2.jar
set CLASSPATH=%CLASSPATH%;target\activejdbc-instrumentation
java -classpath %CLASSPATH% -DoutputDirectory=target\activejdbc-instrumentation org.javalite.instrumentation.Main