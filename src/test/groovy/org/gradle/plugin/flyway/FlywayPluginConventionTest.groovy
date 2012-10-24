package org.gradle.plugin.flyway

import org.gradle.plugin.FlywayPluginTestBase
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.junit.Test

import static org.junit.Assert.*

public class FlywayPluginConventionTest extends FlywayPluginTestBase {

    @Test(expected = AssertionError.class)
    public void shouldAssertForConfigFile() {
        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration
        fail("Should have thrown assertion error for configfile")
    }

    @Test
    public void shouldLoadConfigFile() {
        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration
        assertTrue(flywayConfiguration instanceof FlywayConfiguration)

        assertEquals("jdbc:h2:mem:flyway", flywayConfiguration.getDbUrl())
    }
}
