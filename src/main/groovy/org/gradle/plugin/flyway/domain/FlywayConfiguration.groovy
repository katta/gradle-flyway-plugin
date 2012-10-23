package org.gradle.plugin.flyway.domain

class FlywayConfiguration {

    final Properties properties;

    FlywayConfiguration(Properties properties) {
        this.properties = properties;
    }

    String getDbUrl() {
        return properties.getProperty("flyway.url")
    }

    Properties getProperties() {
        return this.properties;
    }
}
