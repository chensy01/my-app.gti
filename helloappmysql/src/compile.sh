echo begin to compile,please wait.....

export HELLOAPPLIB=`ls ../WEB-INF/lib/*.jar|paste -s -d : -`
javac mypack/Entity/Users.java
cp mypack/Entity/Users.class ../WEB-INF/classes/mypack/Entity/

javac mypack/Entity/UsersId.java
cp mypack/Entity/UsersId.class ../WEB-INF/classes/mypack/Entity/

cp mypack/Entity/Users.hbm.xml ../WEB-INF/classes/mypack/Entity/


javac mypack/Util/IEnvProperties.java
cp mypack/Util/IEnvProperties.class ../WEB-INF/classes/mypack/Util/


javac mypack/Util/EnvProperties.java 
cp mypack/Util/EnvProperties.class ../WEB-INF/classes/mypack/Util/

javac mypack/Util/DbConnection.java
cp mypack/Util/DbConnection.class ../WEB-INF/classes/mypack/Util/

javac -classpath .:${HELLOAPPLIB} mypack/Init.java
cp mypack/Init.class ../WEB-INF/classes/mypack/

javac -classpath .:../WEB-INF/classes/mypack/Util:../WEB-INF/classes/mypack/Entity/User.class:${HELLOAPPLIB} mypack/DispatcherServlet.java
cp mypack/DispatcherServlet.class ../WEB-INF/classes/mypack/

echo compile completed,enjoy...

echo restart server
#oldpath=`pwd`
sh /Users/momo/Downloads/tomcat8/apache-tomcat-8.0.33/bin/shutdown.sh
sh /Users/momo/Downloads/tomcat8/apache-tomcat-8.0.33/bin/startup.sh
echo server restarted
