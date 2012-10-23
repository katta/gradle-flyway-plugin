package org.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MigrateTask extends DefaultTask {

    @TaskAction
    def migrate() {
        def configuration = project.convention.plugins.flyway.flywayConfiguration


        def contextClassLoader = Thread.currentThread().getContextClassLoader()
        contextClassLoader.addURL project.rootDir.toURL()

        Flyway flyway = new Flyway()
        flyway.configure(configuration.properties)
        flyway.migrate();
    }
}
