package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.katta.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.api.tasks.TaskAction

abstract class AbstractFlywayTask extends DefaultTask {

    protected Flyway flyway;

    AbstractFlywayTask() {
        group = "Flyway"

        FlywayConfiguration configuration = getProject().convention.plugins.flyway.flywayConfiguration

        flyway = new Flyway()
        flyway.configure(configuration.getProperties())

        def contextClassLoader = Thread.currentThread().getContextClassLoader()
        contextClassLoader.addURL project.rootDir.toURL()
    }

}
