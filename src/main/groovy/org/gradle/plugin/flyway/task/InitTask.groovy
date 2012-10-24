package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class InitTask extends FlywayTask {

    @TaskAction
    def init() {
        flyway.init()
    }
}
