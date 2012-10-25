package org.gradle.plugin.task

import org.gradle.plugin.FlywayPluginTestBase
import org.junit.Test

public class CleanTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldCleanTheDatabase() {

        def sql = dbConnector()

        findTask("flywayInit").execute();

        def tablesResultSet = dbConnector().connection.metaData.getTables(null, "PUBLIC", "SCHEMA_VERSION", null)
        assert tablesResultSet.next()

        findTask("flywayClean").execute();

        tablesResultSet = sql.connection.metaData.getTables(null, "PUBLIC", "schema_version", null)
        assert !tablesResultSet.next()
    }
}
