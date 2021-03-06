# 2017-S2C-VV

**Sistema da Comunidade Católica - Vila Velha**

Assignment for the 2017's edition of the "Web Development and the Semantic Web" course

### Authors
- [*Allan Rosa*](https://github.com/thisIsChu)
- [*Marco Thomé*](https://github.com/mabrunoro)

### Professor
- [*Vitor Souza*](https://github.com/vitorsouza)

### Implemented
- Base project
- Base database
- Base website
- Administrator creation
- User login
- Priest CRUD
- Volunteer CRUD

## Installation Guide
In order to run this project, here's what you're gonna need:
- [*Java SE*](http://www.oracle.com/technetwork/java/javase/downloads/) (preferentially the last version)
- [*Eclipse IDE for Java EE Developers*](http://www.eclipse.org/downloads/) (our release is Oxygen)
- [*Wildfly*](http://wildfly.org/downloads/) (our version is 11 Final)
- [*MySQL Community Server*](http://dev.mysql.com/downloads/mysql/) (our version is 5.7.20)
- [*MySQL Workbench*](http://dev.mysql.com/downloads/tools/workbench/) (our version is 6.3.9)
- [*MySQL Connector/J JDBC Driver*](http://dev.mysql.com/downloads/connector/j/) (our version is 5.1.44)
It's assumed that the user can handle the installation process of each tool by himself.
We'll also assume `$ECLIPSE_HOME` and `$WILDFLY_HOME` as the folder in which *Eclipse* and *Wildfly* were deployed, respectively.

### Set up *Eclipse* with *Wildfly*
By integrating *Eclipse* and *Wildfly*, the application deployment will be easier.
1. Open *Eclipse*;
1. Open the *Servers* view (if not visible, go to `Window > Show View`);
1. Right-click the blank space at the *Servers* view and select `New > Server`;
1. If there's no *Wildfly* server available:
	1. Open the `Red Hat JBoss Middleware` folder and select `JBoss AS, Wildfly, & EAP Server Tools`;
	1. Click `Next`, download, read and accept the license terms, then click `Finish` and restart *Eclipse*;
	1. Repeat steps **2** and **3** to open the *New Server* dialog again;
1. Open the `JBoss Community` folder and select the *WildFly* version you've downloaded and click `Next` twice;
1. Fill in the server's directory (`$WILDFLY_HOME`) and click `Finish`.

If everything is correct, a *Wildfly* server will appear in *Server*'s view. Starting it and accessing `localhost:8080` on a web browser shows the *Wildfly*'s welcome homepage.

### Set up *Wildfly* with *MySQL*
*WildFly* comes with a [*H2 Database*](http://www.h2database.com/) as default driver. We use *MySQL*, however, so we need to add its driver to *WildFly*'s configuration.
1. Create the `com/mysql/main` structure in `$WILDFLY_HOME/modules`;
1. Unpack the *MySQL Connector/J JDBC Driver* and copy/move the file *mysql-connector-java-\*-bin.jar* to `$WILDFLY_HOME/modules/com/mysql/main`
1. Create a file named *module.xml* with the following content (remember to adjust the connector version accordingly):
	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<module xmlns="urn:jboss:module:1.1" name="com.mysql">
		<resources>
			<resource-root path="mysql-connector-java-5.1.44-bin.jar"/>
		</resources>
		<dependencies>
			<module name="javax.api"/>
		</dependencies>
	</module>
	```
1. Open the file `$WILDFLY_HOME/standalone/configuration/standalone.xml` and look for the `<subsystem xmlns="urn:jboss:domain:datasources:4.0">` tag. Locate `<datasources>` inside this tag and then `<drivers>`. You should see the *H2 Database* driver configuration there. Add the following configuration for *MySQL Connector/J JDBC Driver* next to it:
	```xml
	<driver name="mysql" module="com.mysql">
		<driver-class>com.mysql.jdbc.Driver</driver-class>
	</driver>
	```

### Use it!
You're now ready to start developing *Java EE* projects in *Eclipse*, deploying them on *WildFly* with *MySQL* databases. The steps above are needed only once for all projects.
