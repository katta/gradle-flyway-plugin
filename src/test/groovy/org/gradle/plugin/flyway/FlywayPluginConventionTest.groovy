package org.gradle.plugin.flyway

import org.gradle.plugin.FlywayPluginTestBase
import org.gradle.plugin.flyway.domain.FlywayConfiguration
import org.junit.Test

import static org.junit.Assert.fail

public class FlywayPluginConventionTest extends FlywayPluginTestBase {

    @Test(expected = AssertionError.class)
    public void shouldAssertForConfigFile() {
        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration
        fail("Should have thrown assertion error for configfile")
    }

    @Test
    public void shouldLoadConfigFile() {
        def flywayConfiguration = project.convention.plugins.flyway.flywayConfiguration

        assert flywayConfiguration instanceof FlywayConfiguration
        assert "jdbc:h2:flyway-test".equals(flywayConfiguration.properties["flyway.url"])
    }
}
