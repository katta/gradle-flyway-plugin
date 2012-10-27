# Gradle plugin for Flyway

This plugin povides gradle tasks to run flyway migrations

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
            mavenCentral()
            maven {
                url uri('http://katta.github.com/repository')
            }
        }
        dependencies {
            classpath 'org.katta.gradle.api.plugins:flyway:[VERSION]'
            classpath 'postgresql:postgresql:9.1-901.jdbc4'
        }
    }

    apply plugin: 'flyway'

    flyway {
        driver='org.postgresql.Driver'
        url='jdbc:postgresql://127.0.0.1/flyway'
        user='postgres'
        password='s#cRet'
    }

To use flyway plugin all you have to do is configure your gradle build with the above settings.

* Configure the repositories in the `buildscript` closure where gradle can download build dependencies
* Add dependencies to `flyway plugin` and the `database driver` in `dependencies` section of `buildscript`
* Apply flyway plugin by declaring `apply plugin: 'flyway'`
* Specify the flyway configuration by setting `configFile` in flyway closure to the configuration file path.

## Flyway configuration

You can configure flyway plugin by specifying the appropritate config values in flyway closure like this

    flyway {
        driver='org.postgresql.Driver'
        url='jdbc:postgresql://127.0.0.1/flyway'
        user='postgres'
        password='s#cRet'
    }

The only mandatory configs are the ones mentioned above. Apart from this the following configs are supported

    schemas
    table
    locations
    sqlMigrationPrefix
    sqlMigrationSuffix
    encoding
    placeholderPrefix
    placeholderSuffix
    target
    validationMode
    validationErrorMode
    disableInitCheck

For the details on what each of the above config means refer flyway [wiki](http://code.google.com/p/flyway/wiki/CommandLineMigrate).

# Release Versions

* Latest Release 1.3
* [Release specific documentation](https://github.com/katta/gradle-flyway-plugin/wiki/Release-Versions)



