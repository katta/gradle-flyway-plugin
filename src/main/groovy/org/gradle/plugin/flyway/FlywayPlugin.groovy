package org.gradle.plugin.flyway

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.plugin.flyway.task.InitTask
import org.gradle.plugin.flyway.task.MigrateTask

class FlywayPlugin implements Plugin<Project> {

    Properties flywayConfig;

    @Override
    void apply(Project project) {
        project.convention.plugins.flyway = new FlywayPluginConvention(project)
    }
}
