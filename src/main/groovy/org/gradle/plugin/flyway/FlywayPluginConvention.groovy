package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.plugin.flyway.task.FlywayTask
import org.gradle.plugin.flyway.task.StatusTask

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

        project.task("flywayClean", type: FlywayTask, description: "Drops all database objects including the schema version metatable") {
            action = "clean"
        }
        project.task("flywayInit", type: FlywayTask, description: "Initializes the database with flyway schema version metatable") {
            action = "init"
        }
        project.task("flywayMigrate", type: FlywayTask, description: "Migrates the database with migrations") {
            action = "migrate"
        }
        project.task("flywayValidate", type: FlywayTask, description: "Validates the applied migrations against the ones available on the classpath") {
            action = "validate"
        }
        project.task("flywayStatus", type: StatusTask, description: "Prints the current version of the schema")
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
