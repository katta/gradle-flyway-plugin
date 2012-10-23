package org.gradle.plugin.flyway

import org.gradle.api.Project
import org.gradle.plugin.flyway.domain.FlywayConfiguration

class FlywayPluginConvention {

    final Project project;

    File configFile;
    FlywayConfiguration flywayConfiguration;

    FlywayPluginConvention(Project project) {
        this.project = project;
    }

    def flyway(Closure closure) {
        closure.delegate = this
        closure()

        loadFlywayConfiguration()
    }

    private void loadFlywayConfiguration() {
        def properties = new Properties()
        assert configFile, "Configuration file is not configured for plugin flyway [flyway.configFile]"

        configFile.withInputStream {
            stream -> properties.load(stream)
        }

        this.flywayConfiguration = new FlywayConfiguration(properties)
    }

    public FlywayConfiguration getFlywayConfiguration() {
        return this.flywayConfiguration;
    }
}
