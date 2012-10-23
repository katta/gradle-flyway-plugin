package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

public class FlywayPluginTest {
    Project project = ProjectBuilder.builder().build()

    @Before
    public void setup() {
        project.apply plugin: 'flyway'
    }

    @Test
    public void shouldExecuteInitTask() {
        project.flyway {
            configFile = project.file(configFilePath())
        }

        Task task = project.tasks.find {
            t -> t.name.equals("init")
        }
        task.execute();
    }

    private String configFilePath() {
        Thread.currentThread().getContextClassLoader().getResource("flyway-test-configuration.properties").getPath()
    }

}
