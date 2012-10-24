package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class ValidateTask extends FlywayTask {

    @TaskAction
    def validate() {
        flyway.validate();
    }
}
