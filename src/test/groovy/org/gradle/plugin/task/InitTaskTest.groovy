package org.gradle.plugin.task

import org.junit.Test
import org.gradle.plugin.FlywayPluginTestBase

public class InitTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldExecuteInitTask() {
        findTask("init").execute();
    }
}
