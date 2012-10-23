package org.gradle.plugin.flyway.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import com.googlecode.flyway.core.Flyway
import org.gradle.plugin.flyway.domain.FlywayConfiguration

class InitTask extends DefaultTask {

    @TaskAction
    def init() {
        FlywayConfiguration configuration = getProject().convention.plugins.flyway.flywayConfiguration

        Flyway flyway = new Flyway()
        flyway.configure(configuration.getProperties())
        flyway.init()
    }
}
