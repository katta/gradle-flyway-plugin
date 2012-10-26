package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import org.gradle.api.GradleException

abstract class AbstractFlywayTask extends DefaultTask {

    Flyway flyway;

    AbstractFlywayTask() {
        group = "Flyway"

        def contextClassLoader = Thread.currentThread().getContextClassLoader()
        contextClassLoader.addURL project.rootDir.toURL()
    }

    @TaskAction
    def executeFlywayTask() {
        flyway = new Flyway()
        def config = retrieveConfiguration()
        validate(config)

        flyway.configure(config)

        executeTask(flyway)
    }

    def validate(Properties properties) {
        checkIfExists(properties, "flyway.url")
        checkIfExists(properties, "flyway.driver")
        checkIfExists(properties, "flyway.user")
        checkIfExists(properties, "flyway.password")
    }

    private void checkIfExists(Properties properties, String keyToCheck) {
        if (!properties.hasProperty(keyToCheck)) {
            def key = keyToCheck.replaceFirst("flyway.", "").toLowerCase()
            throw new GradleException("[$key] property must be defined in flyway closure");
        }
    }

    abstract void executeTask(Flyway flyway);


    def Properties retrieveConfiguration() {
        Properties config = new Properties()
        project.flyway.properties.each {
            key, value ->

            if (value != null && value instanceof String) {
                config.put(new String("flyway.$key"), value)
            }
        }
        config
    }

}
