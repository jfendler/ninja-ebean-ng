     _______  .___ _______        ____.  _____   
     \      \ |   |\      \      |    | /  _  \  
     /   |   \|   |/   |   \     |    |/  /_\  \
    /    |    \   /    |    \/\__|    /    |    \
    \____|__  /___\____|__  /\________\____|__  /
         web\/framework   \/                  \/


EBean "NG" (post-7.2.3) support for Ninja
=========================================
EBean is a simple and powerful ORM tool. This plugin allows you to use EBean in any Ninja application.

Due to a change to the EBean API, the original ninja-ebean module only supports the EBean ORM up to version 7.2.3.
In order to not break existing applications, this module is basically a copy of the original module, but provides the new API exclusively, which is likely useful for new applications.   

More
----

 * The original [ninja-ebean module](https://github.com/ninjaframework/ninja-ebean)


Getting started
---------------
Configuring the module for your application is quite easy. There is a demo application that shows you how to do it.
Check out subproject `ninja-ebean-demo/pom.xml` for further information.

More about [EBean ORM](http://www.avaje.org)

Overview
--------

This module actually works with the latest versions of EBean. The module itself depends on version 7.20.1.
Since this module more or less configures the Ebean server, it should be compatible with any Ebean release that continues to support current
configuration properties.

Compatibility with EBean versions up to 7.2.3 is provided through the original ninja-ebean module, which may also support legacy versions of Ebean ORM.

NOTE: This module only supports a single (default) Ebean server.  Feel free to contribute code to the project if you need other features. Thanks!

Setup
-----

1) Add your db conf to your application.conf file. For a simple H2 database:

    ebean.datasource.databaseUrl=jdbc:h2:./testdatabase:tests;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE

For a MySQL database (you'll also need to add the MySQL driver dependency to
your project)

    ebean.ddl.generate = false
    ebean.ddl.run = false
    ebean.models = com.company.models.*,org.otherorg.models.Foo
    ebean.datasource.name = NameOfEbeanServer
    ebean.datasource.databaseUrl = jdbc:mysql://localhost:3306/dbname
    ebean.datasource.databaseDriver = com.mysql.jdbc.Driver
    ebean.datasource.username = root
    ebean.datasource.password = test


Please note that <code>ebean.models</code> accepts a comma delimited list of
both class names as well as packages (just make sure it ends with .*)

2) Add the ninja-ebeans dependency to your pom.xml:

    <dependency>
        <groupId>com.jensfendler</groupId>
        <artifactId>ninja-ebean-ng-module</artifactId>
        <version>0.0.1</version>
    </dependency>

3) Add ebean's enhancer plugin to your pom.xml:

    <plugin>
        <groupId>org.avaje.ebeanorm</groupId>
        <artifactId>avaje-ebeanorm-mavenenhancer</artifactId>
        <version>4.10.1</version>
        <executions>
            <execution>
                <id>ebean-enhancer</id>
                <phase>process-classes</phase>
                <configuration>
                    <classSource>${project.build.outputDirectory}</classSource>
                    <packages>models</packages>
                    <transformArgs>debug=1</transformArgs>
                </configuration>
                <goals>
                    <goal>enhance</goal>
                </goals>
            </execution>
        </executions>
    </plugin>

4) Install the module in your conf.Module:

    protected void configure() {
        // This installs the NinjaEbeanNGModule and handles the lifecycle
        install(new NinjaEbeanNGModule());
    }


And that's it already :)

Thanks
------
Many thanks go to the original authors of the ninja-ebean module, in particular [Raphael Bauer](https://github.com/raphaelbauer) and [Joe Lauer](https://github.com/jjlauer), for virtually all the code in this module. Although I hope to maintain and improve this module over time, it would not exist without them. 
