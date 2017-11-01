# 2017-S2C-VV
Assignment for the 2017 edition of the "Web Development and the Semantic Web" course

**Sistema da Comunidade Católica - Vila Velha**

#### Authors
- [*Allan Rosa*](https://github.com/thisIsChu)
- [*Marco Thomé*](https://github.com/mabrunoro)

#### Professor
- [*Vitor Souza*](https://github.com/vitorsouza)

#### Completed Tasks
- Base project
- Base database
- Base website
- Administrator creation
- User login
- Priest CRUD
- Volunteer CRUD

## Installation Guide
In order to run this project, here's what you're gonna need:
- [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/) (preferentially the last version)
- [Eclipse IDE for Java EE Developers](http://www.eclipse.org/downloads/) (our release is Oxygen)
- [Wildfly](http://wildfly.org/downloads/) (our version is 11 Final)
- [MySQL Community Server](http://dev.mysql.com/downloads/mysql/) (our version is 5.7.20)
- [MySQL Workbench](http://dev.mysql.com/downloads/tools/workbench/) (our version is 6.3.9)
- [MySQL Connector/J JDBC Driver](http://dev.mysql.com/downloads/connector/j/) (our version is 5.1.44)
It's assumed that the user can handle the installation process of each tool by himself.
We'll also assume `$ECLIPSE_HOME` and `$WILDFLY_HOME` as the folder which Eclipse and Wildfly were deployed, respectively.

#### Setup Eclipse with Wildfly
By integrating Eclipse and Wildfly, the application deployment will be easier.
1. Open Eclipse;
1. Open the Servers view (if not visible, Window > Show View menu);
1. Right-click the blank space at the Servers view and select `New > Server`;
1. Open the `Red Hat JBoss Middleware` folder and select `JBoss AS, Wildfly, & EAP Server Tools`;
1. Click `Next`, download, read and accept the license terms, then click `Finish` and restart Eclipse;
1. Repeat steps **2** and **3** to open the *New Server* dialog again;
1. Open the `JBoss Community` folder and select `WildFly X` and click `Next` twice;
1. Fill in the server's directory (`$WILDFLY_HOME`) and click `Finish`.

If everything is correct, a Wildfly server will be shown in *Server*'s view and, after starting it, accessing `localhost:8080` on a web browser shows the Wildfly's welcome homepage.

#### Setup Wildfly with MySQL
WildFly comes with a [H2 Database](http://www.h2database.com/) as default driver. In this tutorial, however, we use MySQL, so we need to add its driver to WildFly's configuration.
