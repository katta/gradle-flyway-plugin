package org.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.api.tasks.TaskAction

class FlywayTask extends DefaultTask {

    protected Flyway flyway;
    String action;

    FlywayTask() {
        group = "Flyway"

        FlywayConfiguration configuration = getProject().convention.plugins.flyway.flywayConfiguration

        flyway = new Flyway()
        flyway.configure(configuration.getProperties())

        def contextClassLoader = Thread.currentThread().getContextClassLoader()
        contextClassLoader.addURL project.rootDir.toURL()
    }

    @TaskAction
    def executeFlywayAction() {
        flyway ."$action"()
    }

}
