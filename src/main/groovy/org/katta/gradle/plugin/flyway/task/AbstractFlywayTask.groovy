package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

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
        flyway.configure(retrieveConfiguration())

        executeTask(flyway)
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
