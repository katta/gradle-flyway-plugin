package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class FlywayTask extends AbstractFlywayTask {

    @TaskAction
    def executeFlywayAction() {
        flyway ."$action"()
    }

}
