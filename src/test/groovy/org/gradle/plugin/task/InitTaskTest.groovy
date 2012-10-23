package org.gradle.plugin.task

import org.gradle.api.Task

import org.junit.Test
import org.gradle.plugin.FlywayPluginTestBase

public class InitTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldExecuteInitTask() {
        Task task = findTask("init")
        task.execute();
    }
}
