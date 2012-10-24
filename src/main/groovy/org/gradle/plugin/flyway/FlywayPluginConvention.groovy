package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.plugin.flyway.task.InitTask
import org.gradle.plugin.flyway.task.MigrateTask
import org.gradle.plugin.flyway.task.CleanTask
import org.gradle.plugin.flyway.task.ValidateTask

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

        project.task("flywayClean", type: CleanTask, description: "Drops all database objects including the schema version metatable")
        project.task("flywayInit", type: InitTask, description: "Initializes the database with flyway schema version metatable")
        project.task("flywayMigrate", type: MigrateTask, description: "Migrates the database with migrations")
        project.task("flywayValidate", type: ValidateTask, description: "Validates the applied migrations against the ones available on the classpath")
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
