package org.gradle.plugin.flyway.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class InitTask extends DefaultTask {

    @TaskAction
    def init() {
        group = "Flyway"

        println(getProject().convention.plugins.flyway.configFile)

        println "initializing flyway plugin !!"
    }

}
