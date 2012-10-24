# Gradle plugin for Flyway

This plugin povides gradle dsl for flyway tasks 

# Flyway Tasks

    flywayClean - Drops all database objects including the schema version metatable
    flywayInit - Initializes the database with flyway schema version metatable
    flywayMigrate - Migrates the database with migrations
    flywayStatus - Prints the current version of the schema
    flywayValidate - Validates the applied migrations against the ones available on the classpath

You can get this help by running `gradle tasks --all` under `Flyway tasks` section also. 

# Usage

    buildscript {
        repositories {
         ....
        }
        dependencies {
            classpath 'org.gradle.api.plugins:flyway:1.0-SNAPSHOT'
            classpath 'postgresql:postgresql:9.1-901.jdbc4'
        }
    }

    apply plugin: 'flyway'

    flyway {
        configFile = file("flyway-config.properties")
    }

To use flyway plugin all you have to do is configure your gradle build with the above settings.

* Configure the repositories in the `buildscript` closure where gradle can download build dependencies
* Add dependencies to `flyway plugin` and the `database driver` in `dependencies` section of `buildscript`
* Apply flyway plugin by declaring `apply plugin: 'flyway'`
* Specify the flyway configuration by setting `configFile` in flyway closure to the configuration file path.

## Flyway configuration

Any configuration that has to be given to flyway has to be mentioned in a property file and specify the path of the property file as `configFile`. Sample config file will look like this

    flyway.driver=org.postgresql.Driver
    flyway.url=jdbc:postgresql://127.0.0.1/flyway
    flyway.user=postgres
    flyway.password=password
    flyway.schemas=appdb

For the complete refence of flyway configuration(options) refer flyway [wiki](http://code.google.com/p/flyway/wiki/CommandLineMigrate) under each of the commands

# Release Versions

Version 1.0 is released - To use it you just have to add a new `repository` in your build pointing to the URL `https://katta.github.com/repository` and declare a classpath dependency to `org.gradle.api.plugins:flyway:1.0`


