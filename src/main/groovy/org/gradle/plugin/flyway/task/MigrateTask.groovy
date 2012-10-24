package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class MigrateTask extends FlywayTask {

    @TaskAction
    def migrate() {
        def contextClassLoader = Thread.currentThread().getContextClassLoader()
        contextClassLoader.addURL project.rootDir.toURL()

        flyway.migrate();
    }
}
