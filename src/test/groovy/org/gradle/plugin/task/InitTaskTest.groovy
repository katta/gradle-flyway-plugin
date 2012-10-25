package org.gradle.plugin.task

import org.gradle.plugin.FlywayPluginTestBase
import org.junit.Test

public class InitTaskTest extends FlywayPluginTestBase {

    @Test
    public void shouldExecuteInitTask() {
        def sql = dbConnector()

        def tablesResultSet = sql.connection.metaData.getTables(null, "*", "schema_version", null)
        assert !tablesResultSet.next()

        findTask("flywayInit").execute();

        def row = sql.firstRow("select * from schema_version")
        assert "0".equals(row.getProperty("version"))
        assert "INIT".equals(row.getProperty("type"))
    }
}
