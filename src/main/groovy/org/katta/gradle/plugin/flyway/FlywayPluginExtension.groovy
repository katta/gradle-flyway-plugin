package org.katta.gradle.plugin.flyway

class FlywayPluginExtension {
    String driver;
    String url;
    String user;
    String password;
    String schemas;
    String table;
    String locations;
    String sqlMigrationPrefix;
    String sqlMigrationSuffix;
    String encoding;
    String placeholderPrefix;
    String placeholderSuffix;
    String target;
    String validationMode;
    String validationErrorMode;
    String disableInitCheck;
}
