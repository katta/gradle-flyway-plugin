package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class MigrateTask extends FlywayTask {

    @TaskAction
    def migrate() {
        flyway.migrate();
    }
}
