package org.gradle.plugin.flyway

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.plugin.flyway.task.InitTask

class FlywayPlugin implements Plugin<Project> {

    Properties flywayConfig;

    @Override
    void apply(Project project) {
        project.convention.plugins.flyway = new FlywayPluginConvention(project)

        project.task("init", type: InitTask, description: "Initializes the database with flyway metatable")
    }
}
