package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class CleanTask extends FlywayTask {

    @TaskAction
    def clean() {
        flyway.clean()
    }
}
