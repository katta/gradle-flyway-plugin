package org.gradle.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.gradle.api.Task

public class FlywayPluginTestBase {

    protected Project project;

    @Before
    public void setupBase() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'flyway'

        project.flyway {
            configFile = project.file(resourceFilePath("flyway-test-configuration.properties"))
        }
    }

    protected Task findTask(String name) {
        Task task = project.tasks.find {
            t -> t.name.equals(name)
        }
        task
    }

    protected String resourceFilePath(String fileName) {
        Thread.currentThread().getContextClassLoader().getResource(fileName).getPath()
    }
}
