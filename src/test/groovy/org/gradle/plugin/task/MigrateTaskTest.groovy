package org.gradle.plugin.task

import org.gradle.plugin.FlywayPluginTestBase
import org.junit.Test

public class MigrateTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldMigrate() {
        findTask("migrate").execute();
    }
}
