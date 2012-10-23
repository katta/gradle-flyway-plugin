package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import static org.junit.Assert.fail

public class FlywayPluginConventionTest {

    Project project

    @Before
    public void setup() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'flyway'
    }

    @Test(expected = AssertionError.class)
    public void shouldAssertForConfigFile() {
        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration
        fail("Should have thrown assertion error for configfile")
    }

    @Test
    public void shouldLoadConfigFile() {

        String configFilePath = configFilePath()

        project.flyway {
            configFile = project.file(configFilePath)
        }

        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration
        assertTrue(flywayConfiguration instanceof FlywayConfiguration)

        assertEquals("someurl", flywayConfiguration.getDbUrl())
    }

    private String configFilePath() {
        Thread.currentThread().getContextClassLoader().getResource("flyway-test-configuration.properties").getPath()
    }
}
