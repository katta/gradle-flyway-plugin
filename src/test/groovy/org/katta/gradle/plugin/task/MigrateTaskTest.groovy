package org.katta.gradle.plugin.task

import org.katta.gradle.plugin.FlywayPluginTestBase
import org.junit.Test

public class MigrateTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldMigrate() {
        project.tasks.flywayMigrate.execute();

        def firstRow = dbConnector().firstRow("select * from employee");
        assert "katta".equals(firstRow.getProperty("emp_name"))
    }

}
