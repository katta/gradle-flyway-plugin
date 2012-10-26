package org.katta.gradle.plugin.flyway

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.katta.gradle.plugin.flyway.task.FlywayTask
import org.katta.gradle.plugin.flyway.task.StatusTask

class FlywayPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create("flyway", FlywayPluginExtension)

        project.task("flywayClean", type: FlywayTask, description: "Drops all database objects including the schema version metatable")
        project.task("flywayInit", type: FlywayTask, description: "Initializes the database with flyway schema version metatable")
        project.task("flywayMigrate", type: FlywayTask, description: "Migrates the database with migrations")
        project.task("flywayValidate", type: FlywayTask, description: "Validates the applied migrations against the ones available on the classpath")
        project.task("flywayStatus", type: StatusTask, description: "Prints the current version of the schema")
    }
}
