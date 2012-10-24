package org.gradle.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.gradle.api.Task
import groovy.sql.Sql
import org.junit.After

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

    @After
    public void teardown() {
        findTask("flywayClean").execute();
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

    protected Sql dbConnector() {
        def properties = project.convention.plugins.flyway.flywayConfiguration.properties
        Sql.newInstance("${properties['flyway.url']}", "${properties['flyway.user']}", "${properties['flyway.password']}", "${properties['flyway.driver']}")
    }
}
