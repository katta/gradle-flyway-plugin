package org.katta.gradle.plugin.flyway.domain

class FlywayConfiguration {

    final Properties properties;

    FlywayConfiguration(Properties properties) {
        this.properties = properties;
    }

    Properties getProperties() {
        return this.properties;
    }
}
