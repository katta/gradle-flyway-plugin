package org.katta.gradle.plugin.task

import org.gradle.api.Project
import org.gradle.api.tasks.TaskExecutionException
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class ExtensionPropertiesValidationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    protected Project project;

    @Before
    public void setup() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'flyway'
    }

    @Test()
    public void validateForMandatoryConfig() {
        project.flyway {
        }

        expectedException.expect(TaskExecutionException.class)

        project.tasks.flywayInit.execute()
    }

}
