package org.gradle.plugin.task

import org.gradle.plugin.FlywayPluginTestBase
import org.junit.Test

public class FlywayTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldRunAllFlywayTasks() {
        findTask("flywayClean").execute();
        findTask("flywayInit").execute();
        findTask("flywayMigrate").execute();
        findTask("flywayValidate").execute();

        findTask("flywayClean").execute();
    }
}
