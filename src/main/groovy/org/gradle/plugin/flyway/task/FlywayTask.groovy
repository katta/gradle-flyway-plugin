package org.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import org.gradle.api.DefaultTask
import org.gradle.plugin.flyway.domain.FlywayConfiguration

abstract class FlywayTask extends DefaultTask {

    protected Flyway flyway;

    FlywayTask() {
        group = "Flyway"

        FlywayConfiguration configuration = getProject().convention.plugins.flyway.flywayConfiguration

        flyway = new Flyway()
        flyway.configure(configuration.getProperties())
    }
}
