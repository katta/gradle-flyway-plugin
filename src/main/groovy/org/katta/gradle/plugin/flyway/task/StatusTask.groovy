package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import com.googlecode.flyway.core.metadatatable.MetaDataTableRow

class StatusTask extends AbstractFlywayTask {

    @Override
    void executeTask(Flyway flyway) {

        MetaDataTableRow metaTableRow = flyway.status()
        StringBuilder builder = new StringBuilder("-------------Schema Status------------\n")
        builder.append("Version :").append(metaTableRow.getVersion()).append("\n")
                .append("Description :").append(metaTableRow.getDescription()).append("\n")
                .append("Type :").append(metaTableRow.getMigrationType()).append("\n")
                .append("Installed On :").append(metaTableRow.getInstalledOn()).append("\n")
                .append("State :").append(metaTableRow.getState())

        println builder.toString()
    }
}