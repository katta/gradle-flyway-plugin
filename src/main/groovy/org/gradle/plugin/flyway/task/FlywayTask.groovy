package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction

class FlywayTask extends AbstractFlywayTask {

    @TaskAction
    def executeFlywayAction() {

        def taskAction = this.name.replaceFirst("flyway","").toLowerCase();
        println "Executing flyway $taskAction"

        flyway ."$taskAction"()
    }

}
