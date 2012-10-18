package org.gradle

import org.gradle.plugins.ide.idea.model.Project
import org.gradle.api.Plugin

class FlywayPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        println "project name: " + project.name
    }
}
