package org.gradle.plugin.flyway

import org.gradle.api.Plugin
import org.gradle.api.Project

class FlywayPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.convention.plugins.flyway = new FlywayPluginConvention(project)
    }
}
