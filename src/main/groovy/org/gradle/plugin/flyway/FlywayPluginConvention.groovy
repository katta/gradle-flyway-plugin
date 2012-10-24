package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.plugin.flyway.task.InitTask
import org.gradle.plugin.flyway.task.MigrateTask

class FlywayPluginConvention {

    final Project project;

    File configFile;
    FlywayConfiguration flywayConfiguration;

    FlywayPluginConvention(Project project) {
        this.project = project;
    }

    def flyway(Closure closure) {
        closure.delegate = this
        closure()

        loadFlywayConfiguration()

        project.task("init", type: InitTask, description: "Initializes the database with flyway schema version metatable")
        project.task("migrate", type: MigrateTask, description: "Migrates the database with migrations")
    }

    private void loadFlywayConfiguration() {
        def properties = new Properties()
        assert configFile, "Configuration file is not configured for plugin flyway [flyway.configFile]"

        configFile.withInputStream {
            stream -> properties.load(stream)
        }

        this.flywayConfiguration = new FlywayConfiguration(properties)
    }

    public FlywayConfiguration getFlywayConfiguration() {
        return this.flywayConfiguration;
    }
}
